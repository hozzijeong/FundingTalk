package com.fundingtalk.fundingtalk.Main.Loan.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.TrafficStats;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fundingtalk.fundingtalk.AppHelper.Loan_BaseFragment;
import com.fundingtalk.fundingtalk.Main.Loan.Item.Apt_Info;
import com.fundingtalk.fundingtalk.Main.Loan.Item.Calc;
import com.fundingtalk.fundingtalk.Main.Loan.Item.City;
import com.fundingtalk.fundingtalk.Main.Loan.Item.City_First;
import com.fundingtalk.fundingtalk.Main.Loan.Item.City_Second;
import com.fundingtalk.fundingtalk.Main.Loan.Item.City_Third;
import com.fundingtalk.fundingtalk.Main.Loan.Item.Loan_Apt_Info;
import com.fundingtalk.fundingtalk.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Loan_Specific_Info_Fragment extends Loan_BaseFragment implements View.OnClickListener {

    @BindView(R.id.address_do) Button first_city;
    @BindView(R.id.address_si) Button second_city;
    @BindView(R.id.address_gu) Button third_city;
    @BindView(R.id.address_specific) EditText specific_address;
    @BindView(R.id.before_loan_et) EditText before_loan;
    @BindView(R.id.wish_loan_et) EditText wish_loan;
    @BindView(R.id.cost_result) TextView house_cost;
    @BindView(R.id.check_limit) Button check_limit;
    @BindView(R.id.check_address) Button check_address;
    @BindView(R.id.loan_specific_back) Button back;

    public static boolean login_temp_state = true; // 로그인 여부를 확인하는 변수
    public static boolean  counsel_state; // 상담 가능 여부를 확인하는 변수 ( 만약에 시작 ltv 가 최저 ltv 보다 낮다면 그냥 상담)
    public static Loan_Apt_Info loan_apt_info; // 최종적으로 선택된 아파트의 정보를 담는 class


    private int apt_max_cnt = 0;
    private int city_num = 0;
    private Calc calc; // 계산식이 들어가 있는 클래스
    private City_First city; // 선택된 도시들의 정보를 담는 class innerclass로 second -> third가 존재
    private ArrayList<City> cities = new ArrayList<>(); // DB에서 파싱한 도시 정보를 저장하는 클래스 배열
    private ArrayList<City> first_cities = new ArrayList<>();
    private ArrayList<Apt_Info> apt_infos = new ArrayList<>(); // xml 파싱으로 리스트업된 아파트들의 정보를 저장하는 배열
    private final String KEY = "q0HJwcj%2F%2F4%2FAVUrU4w5RtlIRXnl1vYUBEQQppg0cz2Hmy0pTeor3jCrjgRVwdE6a%2BVTAdWIzIqO7YacFNK7Rbg%3D%3D";
    private String base_url ="http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev?";
    private FirebaseFirestore database; // 시/도, 시/군/구, 읍/면/동 들의 정보들이 저장된 fireStore와 연동하기 위한 변수

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.loan02_specific_info_fragment,container,false);
        ButterKnife.bind(this,v);
        check_limit.setOnClickListener(this);
        check_address.setOnClickListener(this);
        first_city.setOnClickListener(this);
        second_city.setOnClickListener(this);
        third_city.setOnClickListener(this);
        back.setOnClickListener(this);
        database = FirebaseFirestore.getInstance();
        setReset();
        getFirstCity();
        /*
            TextView 밑줄 긋는 방법
            textview.setPaintFlags(textview.PaintFlags()|Paint.UNDERLINE_TEXT_FLAG);
         */

        return v;
    }

    @Override
    public void onClick(View view) {
        /*
            도시 선택시 해당 구역에만 포함되는 도시들을 리스트업 할것 .
         */
        switch (view.getId()){
            case R.id.address_do:
                if(city_num == 0){
                    showDialog(city_num,first_cities);
                    city_num++;
                    // 첫번째 도시만 데이터 양이 적으니까 미리 받아 놓을까?
                }else{
                    // 리셋하고 다시 창을 띄워주는데 시간이 좀 걸림.
                    setReset();
                    showDialog(city_num,first_cities);
                }
                break;
            case R.id.address_si:
                if(city_num == 1){
                    // 두번째 도시를 클릭했을 때도 해당 정보를 받아와야 함.
                    // 어떻게 받아오지? 따로 자료형을 만들었지만 너무 비효율적인 것 같음.
                    // 심지어 잘 구현되지도 않음. 세번째 버튼이 구현 안됨 .
                    showDialog(city_num,cities);
                }else{
                    city_num = 1;
                    second_city.setText("");
                    third_city.setText("");
                    third_city.setEnabled(false);
                    check_address.setEnabled(false);
                    showDialog(city_num,city.second_info);
                }
                    city_num++;
                break;
            case R.id.address_gu:
                if(city_num == 2){
                    showDialog(city_num,cities);
                }
                break;
            case R.id.check_address:
                ArrayList<Apt_Info> temp = new ArrayList<>();
                String input_name = specific_address.getText().toString().trim();
                // 여기서 이제 city fourth에 배열로 법정동 명들이 저장되어 있음
                // apt_infos의 local_dong이 fourth_city에 있는 동 중에 하나라도 포함되어 있고,
                // 아파트 이름이 포함되어 있으면 그때 temp.add를 하면 됨.
                // 도시 검색에서 null이 적용됨. 이거한번 확인해 봐야함
                // 아파트 인포에 값을 넣었고, city.citysecond.city-> 태평동이 나왔어.
                // 그렇다면 이제 아파트 인포를 돌려서 법정동이 태평동인 것들과 아파트 이름을 포함한 아파트 값을 넣으면 됨.
                // 반복문의 순서가 바뀌어야함.

                for(int i=0; i<city.city_second.city_third.fourth_city.size(); i++){
                    for(int j=0; j<apt_infos.size(); j++){
                        if(city.city_second.city_third.fourth_city.get(i).city_name.trim().
                                equals(apt_infos.get(j).local_dong)
                                && apt_infos.get(j).apt_name.contains(input_name)){
                            temp.add(apt_infos.get(j));
                        }
                    }
                }
                Collections.sort(temp ,myComparator); // "가나다" 순으로 정렬
                // 정렬 후, 중복된 정보 삭제.

                // 아파트 매매 가격 기준을 평균으로 나눔.(같은 아파트/평수일 경우에) 평균값을 산정한다.
                // 그렇다면 배열을 따로 만들어서, 평균값이 구해진 아파트만 배열에 추가하는 방식으로 구현하기
                if(temp!= null){
                    // 아파트 이름 정렬
                    for (int i=0 ;i<temp.size(); i++){
                        loanActivity.show_Log(temp.get(i).apt_name);
                        loanActivity.show_Log(temp.get(i).local_dong);
                    }
                    showSpecificApt(getAverage(temp));
                }

                break;
            case R.id.check_limit:
                calc.before_loan = Long.parseLong(before_loan.getText().toString().trim());
                calc.wish_loan = Long.parseLong(wish_loan.getText().toString().trim());
                calc.getStart_ltv();
                /*
                    최소 조건을 입력 받고 조건에 해당하면 검색 가능하게끔 구현
                    로그인 했을 경우와 하지 않았을 경우
                 */
                calc.getApply_ltv();
                loan_apt_info.min_ltv =  calc.min_ltv; // 뒷장에 사용할 최소 ltv 구함.
                //대출 가능 금액 산정 -> pos_cost;
                // 적용 ltv 가 max ltv와 같거나 크거나 || 시작 ltv가 최소 ltv 보다 작으면 상담신청
                loanActivity.show_Log("\nstart: "+calc.start_ltv+"\nmin: "+calc.min_ltv+
                        "\nmax: "+calc.max_ltv+"\napply: "+calc.apply_ltv);
                if(calc.start_ltv<calc.min_ltv || calc.apply_ltv>=calc.max_ltv){
                    counsel_state = true;
                    loanActivity.show_Log("상담 신청");
                    // 상담 신청 페이지를 따로 제작해야함


                }else{
                    counsel_state = false;
                    long max_cost = calc.max_cost();
                    if(login_temp_state) {
                        if (max_cost >= calc.wish_loan) {
                            loan_apt_info.pos_cost = calc.wish_loan;
                        } else {
                            loan_apt_info.pos_cost = calc.max_cost();
                        }
                        //대출 금리 산정
                        loan_apt_info.rate = calc.calc_loan_interest_rate();
                    }else{
                        loan_apt_info.pos_cost = calc.max_cost();
                        loan_apt_info.rate = calc.min_rate*100;
                    }
                }

                loanActivity.changeFragment(R.id.loan_main_layout,loanActivity.loan_result_fragment);

                break;
                case R.id.loan_specific_back:
                    loanActivity.changeFragment(R.id.loan_main_layout,loanActivity.loan_base_info_fragment);
                break;
        }
    }
    private void getAptDealInfo(){
        /*
            아파트 데이터 정보를 얻어오는 method.
            거래 날짜를 일단은 지난달로 설정 & 한번에 얻어오는 정보를 50개로 설정함.

         */
        StrictMode.enableDefaults();
        String url = base_url+"ServiceKey="+KEY+
                "&LAWD_CD="+city.city_second.local_code+
                "&DEAL_YMD=202007&numOfRows="+apt_max_cnt;
        loanActivity.show_Log(url);
        new Thread(new Runnable(){
            @Override
            public void run() {
                TrafficStats.setThreadStatsTag(1);
                pullParsing(url);
            }
        }).start();
    }
    protected void showDialog(int num, ArrayList<City> arrayList){
        /*  num
             0 - first -> 시/도
             1 - second -> 시/군/구
             2 - third -> 읍/면/동
            으로 나누어서 해당 리스트를 매번 변경시킴.
            firebase 에서 얻어오는 정보 중 중요한 것은 도시 이름과 그 도시의 idx( 다음 도시 데이터를 얻기 위함)
            이기 때문에 2가지를 중요하게 설정한다.

            데이터가 한꺼번에 몰린다면 runtimeException이 나기때문에, "조회하기"를 눌렀을 때, 아파트 정보를 받아오기 보다는
            3번째 도시를 선택했을 때 아파트 정보를 미리 받아와서 Apt_Info 배열에 저장한다.
                -> 아파트 정보를 얻는데 필요한 것은
                    1. API key값
                    2. 지역코드 (2번째 도시 설정에서 얻음)
                    3. 계약 날짜 (지난달로 설정함)
                    이기 때문에 미리 정보를 얻어 올 수 있다.
         */
        AlertDialog.Builder ab = new AlertDialog.Builder(loanActivity);
        String[] items = new String[arrayList.size()];
        long[] index = new long[arrayList.size()];
        for(int k=0; k<arrayList.size(); k++){
            items[k] = arrayList.get(k).city_name;
            index[k] = arrayList.get(k).index;
        }

        ab.setSingleChoiceItems(items,0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (num){
                    case 0:
                        city = new City_First(items[i],index[i]);
                        first_city.setText(city.city_name);
                        second_city.setEnabled(true);
                        house_cost.setText("");
                        specific_address.setText("");
                        getCity(city.index,"second_city_info");
                        // 2번째 도시 정보를 받아옴. 근데 여기서 다시 첫 번째를 클릭한다면?
                        break;
                    case 1:
                        city.city_second = new City_Second(items[i],index[i],
                                arrayList.get(i).local_code,arrayList.get(i).ltv);
                        second_city.setText(city.city_second.city_name);
                        loanActivity.show_Log("지역 코드: "+city.city_second.local_code
                                +"\nLtv: "+city.city_second.ltv);
                        third_city.setEnabled(true);
                        house_cost.setText("");
                        specific_address.setText("");
                        getCity(city.city_second.index,"third_city_info");
                        break;
                    case 2:
                        city.city_second.city_third = new City_Third(items[i],index[i]);
                        third_city.setText(city.city_second.city_third.city_name);
                        house_cost.setText("");
                        specific_address.setText("");
                        getCity(city.city_second.city_third.index,"fourth_city_info");
                        check_address.setEnabled(true);
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        ab.show();
        ab.create();
    }
    protected void showSpecificApt(ArrayList<Apt_Info> arrayList){
        /*
            아파트 이름을 정확하게 입력한다고 해도, (동, 호수는 입력 받는 것은 나중에 추가 예정)
            여러가지 아파트 이름이 나올 수 있기 때문에, 입력받은 아파트의 이름을 포함하는 모든 거래 매물 자료들을
            Apt_Info 클래스에 저장해서, 해당 아파트를 클릭하면 해당 구매 정보가 나올 수 있도록 유도.

         */
        AlertDialog.Builder ab = new AlertDialog.Builder(loanActivity);
        String[] aptname = new String[arrayList.size()];
        for(int i=0; i<arrayList.size(); i++){
            aptname[i] = arrayList.get(i).full_name;
        }
        if(aptname.length == 0){
            ab.setMessage("매매정보가 없습니다.");
        }else{
            ab.setSingleChoiceItems(aptname, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    long real_cost = arrayList.get(i).avg_cost;
                    specific_address.setText(arrayList.get(i).full_name);
                    house_cost.setText(real_cost+" 만원");
                    loanActivity.show_Log(real_cost+"");
                    //최종적으로 대출용 아파트의 정보 ( 실거래가와 LTV)를 저장하는 클래스 생성
                    loan_apt_info = new Loan_Apt_Info(real_cost,city.city_second.ltv); // 펀딩톡 감정가와
                    loan_apt_info.apt_name = arrayList.get(i).full_name; // 뒷장에 사용할 아파트 이름 저장& 가격은 realcost 사용.

                    // 대출 최소 대출 금액을 먼저 입력하기 위해서...
                    calc = new Calc(loan_apt_info.real_cost,loan_apt_info.ltv); // min 이랑 max ltv 설정 완료.
                    check_limit.setEnabled(true);
                    dialogInterface.dismiss();
                }
            });
        }
        ab.show();
        ab.create();
    }
    private void setReset(){
        /*
            주소를 바꾸려고 할 때, 이전 것을 클릭하면, 아예 초기화 시켜버림
         */
        city = null;
        cities.clear();
        second_city.setText("");
        third_city.setText("");
        apt_infos.clear();
        loan_apt_info = null;
        second_city.setEnabled(false);
        third_city.setEnabled(false);
        check_address.setEnabled(false);
        check_limit.setEnabled(false);
        house_cost.setText("");
        before_loan.setText("");
        wish_loan.setText("");
        city_num = 0;
    }
    private void getCity(long idx,String path){
        /*
            이전에 있던 도시 정보들을 깔끔하게 지워주고,
            부모 idx값 과 두 번째 도시인지 세 번재 도시인지 문서 경로를 입력받아
            cities Array배열에 새롭게 저장.

            저장된 cities 배열이 showDialog 에서 Dialog로 보여지는 것!
         */
        database.collection(path).
                whereEqualTo("parent_idx",idx).get().
                addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            switch (path){
                                case "second_city_info":
                                    cities.clear();
                                    city.second_info.clear();
                                    int cnt = 0;
                                    for(QueryDocumentSnapshot doc:task.getResult()){
                                        cities.add(new City(doc.getString("second_city"),doc.getLong("idx"),
                                                doc.getLong("local_code"),doc.getString("ltv")));
                                        city.second_info.add(cities.get(cnt));
                                        cnt++;
                                    }

                                    break;
                                case "third_city_info":
                                    cities.clear();
                                    for(QueryDocumentSnapshot doc: task.getResult()){
                                        cities.add(new City(doc.getString("third_city"),
                                                doc.getLong("idx")));
                                    }
                                    getMaxCount();
                                    break;
                                case "fourth_city_info":
                                    for(QueryDocumentSnapshot doc:task.getResult()){
                                        // 도시 이름을 city가 아니라 idx 로 설정했음 (내잘못...)
                                        // 태평동을 먹었는데?
                                        city.city_second.city_third.fourth_city.
                                                add(new City(doc.getString("fourth_idx"),doc.getLong("idx")));
                                    }

                                    for(int i=0; i<city.city_second.city_third.fourth_city.size(); i++){
                                        loanActivity.show_Log("add된 법정동: "+city.city_second.city_third.fourth_city.get(i).city_name);
                                    }

                                    getAptDealInfo();
                                    break;
                            }
                        }
                    }
                });
    }
    private void getFirstCity(){
        /*
            데이터 파싱할때 idx 값에 따라 "where.equalto"방식 활용 할 것.
            제일 처음 도시 정보를 얻는 과정.

         */
        database.collection("city_info").get().
                addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(QueryDocumentSnapshot doc: task.getResult()){
                        first_cities.add(new City(doc.getString("first_city"),
                                doc.getLong("idx")));
                    }
                }else{
                    loanActivity.show_Log("failed");
                }
            }
        });

    }
    private void pullParsing(String base_url){
        /*
            오픈 API 에서 xml 데이터를 파싱하는 과정
            내가 필요한 정보는 아파트의 이름과 거래 금액이기 때문에 해당 정보들만
            cities 배열에 add 하고 나머지는 add하지 않는다.
         */
        try {
            URL url = new URL(base_url);
            InputStream is = url.openStream();
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new InputStreamReader(is, "utf-8"));
            int parserEvent = parser.getEventType();
            Apt_Info apt_info = null;
            String tag = "";
            while(parserEvent != XmlPullParser.END_DOCUMENT){
                switch (parserEvent){
                    case XmlPullParser.START_DOCUMENT:
                        Log.d("LOG","파싱 시작");
                        break;
                    case XmlPullParser.START_TAG:
                        //아파트 정보를 얻을 때 해당 법정동 "동" 까지 확인하기.
                        tag = parser.getName();
//                        Log.d("LOG","start Tag:"+tag);
                        if(tag.equals("item")){
                            apt_info = new Apt_Info();
                        }
                        else if(tag.equals("아파트")){
                            apt_info.apt_name = parser.nextText();
                            loanActivity.show_Log("아파트: "+apt_info.apt_name);

                        }else if(tag.equals("거래금액")){
                            String temp = parser.nextText().replace(",","");
                            apt_info.deal_amount = temp.trim();
                            loanActivity.show_Log("금액: "+apt_info.deal_amount);
                        }else if (tag.equals("전용면적")){
                            apt_info.size = parser.nextText();
                            loanActivity.show_Log("사이즈: "+apt_info.size);
                        }else if(tag.equals("법정동")){
                            String temp = parser.nextText();
                            apt_info.local_dong = temp.trim();
                            loanActivity.show_Log("법정동: "+apt_info.local_dong);
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        tag = parser.getName();
//                        loanActivity.show_Log("End_Tag: "+tag);
                        if(tag.equals("item")){
                            apt_infos.add(apt_info);
                            apt_info = null;
                        }
                        break;
                }
                try{
                    parserEvent = parser.next();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        loanActivity.show_Log("파싱 끝, 사이즈: "+apt_info.size);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void getMaxCount(){
        StrictMode.enableDefaults();
        // 재탕 할때(초기화 했을때) citysecond의 값이 null 이 되서 오류 발생
        String url = base_url+"ServiceKey="+KEY+
                "&LAWD_CD="+city.city_second.local_code+
                "&DEAL_YMD=202007";
        loanActivity.show_Log(url);
        new Thread(new Runnable(){
            @Override
            public void run() {
                TrafficStats.setThreadStatsTag(1);
                countParsing(url);
            }
        }).start();
    }
    private void countParsing(String base_url){
        try {
            URL url = new URL(base_url);
            InputStream is = url.openStream();
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new InputStreamReader(is, "utf-8"));
            int parserEvent = parser.getEventType();
            Apt_Info apt_info = null;
            String tag = "";
            while(parserEvent != XmlPullParser.END_DOCUMENT){
                switch (parserEvent){
                    case XmlPullParser.START_DOCUMENT:
                        Log.d("LOG","개수 파싱 시작");
                        break;
                    case XmlPullParser.START_TAG:
                        //아파트 정보를 얻을 때 해당 법정동 "동" 까지 확인하기.
                        tag = parser.getName();
//                        Log.d("LOG","start Tag:"+tag);
                        if(tag.equals("totalCount")){
                            apt_max_cnt = Integer.parseInt(parser.nextText().trim());
                        }

                        break;
                    case XmlPullParser.END_TAG:
                        tag = parser.getName();
//                        loanActivity.show_Log("End_Tag: "+tag);
                        break;
                }
                try{
                    parserEvent = parser.next();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            loanActivity.show_Log("개수 파싱 끝, 개수: "+apt_max_cnt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final static Comparator<Apt_Info> myComparator= new Comparator<Apt_Info>() {
        private final Collator collator = Collator.getInstance();
        @Override
        public int compare(Apt_Info object1,Apt_Info object2) {
            return collator.compare(object1.getApt_name()+"/"+object1.size,
                    object2.getApt_name()+"/"+object2.size);

        }
    };
    private ArrayList<Apt_Info> getAverage(ArrayList<Apt_Info> arrayList){
        // arrayList = 정렬된 아파트의 이름들,(중복된 것들있음)
        ArrayList<Apt_Info> avg_list = new ArrayList<>();
        int size = arrayList.size();
        int cnt = 0;
        int case_cnt = 1;
        long avg_cost = 0;
        long main_cost = 0;

        if(size >1){
            for(int i=1; i<size; i++){
                // 아파트 평균값 계산식 다시 해보기
                String cmp1_name = arrayList.get(cnt).apt_name+ "/"+arrayList.get(cnt).size;
                String cmp2_name = arrayList.get(i).apt_name+ "/"+arrayList.get(i).size;
                int idx1 = cmp1_name.indexOf(".");
                int idx2 = cmp2_name.indexOf(".");
                cmp1_name = cmp1_name.substring(0,idx1);
                cmp2_name = cmp2_name.substring(0,idx2);
                main_cost = Long.parseLong(arrayList.get(cnt).deal_amount); // 여기서 값이 계속 초기화가 됨.
                if(cmp1_name.equals(cmp2_name)){
                    avg_cost += Long.parseLong(arrayList.get(i).deal_amount);
                    case_cnt++;
                }else{
                    avg_cost = ((avg_cost+main_cost)/case_cnt);
                    String full_name = arrayList.get(cnt).apt_name+"(전용면적: "+arrayList.get(cnt).size+"㎡)";
                    avg_list.add(new Apt_Info(avg_cost,full_name));
                    cnt = i;
                    case_cnt = 1;
                    main_cost = 0;
                    avg_cost = 0;
                }
            }
        }else if(size == 1){
            String full_name = arrayList.get(0).apt_name+"(전용면적: "+arrayList.get(0).size+"㎡)";
            avg_cost = Long.parseLong(arrayList.get(0).deal_amount);
            avg_list.add(new Apt_Info(avg_cost,full_name));
        }
        for(int i=0; i<avg_list.size(); i++){
            loanActivity.show_Log(avg_list.get(i).full_name+"/"+avg_list.get(i).avg_cost);
        }

        return avg_list;
    }

}
