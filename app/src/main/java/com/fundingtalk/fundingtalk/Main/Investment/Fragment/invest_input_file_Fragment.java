package com.fundingtalk.fundingtalk.Main.Investment.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fundingtalk.fundingtalk.AppHelper.Main_BaseFragment;
import com.fundingtalk.fundingtalk.Main.Custom.Item.Item;
import com.fundingtalk.fundingtalk.Main.MainActivity;
import com.fundingtalk.fundingtalk.R;
import com.fundingtalk.fundingtalk.Main.Custom.Fragment.Custom_Invest_List_Fragment;

import static com.fundingtalk.fundingtalk.Main.Custom.Fragment.Custom_Invest_List_Fragment.*;

public class invest_input_file_Fragment extends Main_BaseFragment {

    private int ok_money = 0;
    private int ok_confirm = 0;

    static public int back_check = 0; //몇번째 페이지로 뒤로갈지?
    static public double rating = 0; // 수익률
    static public int now_money = 0; //로그인할때 설정해주기
    static public String now_name;

    static public String total_info_c;
    static public String address_c;


    private TextView calc_money;
    private TextView n_money;
    private TextView n_name;
    private String money_info = "총 투자 금액";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.invest_input_file_fragment,container,false);

        n_money = v.findViewById(R.id.avail_money);
        n_money.setText("현재 해당상품에 투자가능한 금액은 " + now_money + " 만원입니다.");

        Spannable span = (Spannable) n_money.getText();
        span.setSpan(new RelativeSizeSpan(1.5f), 18, 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        n_name = v.findViewById(R.id.info);
        n_name.setText("나 "+ now_name + " 은 상기내용을 확인하였으며, 그 내용에");

        Spannable span2 = (Spannable) n_name.getText();
        span2.setSpan(new RelativeSizeSpan(1.5f), 2, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        calc_money = v.findViewById(R.id.add_money);

        Button back = (Button)v.findViewById(R.id.invest_back_activity);
        back.setOnClickListener(new View.OnClickListener() { // 이미지 버튼 이벤트 정의
            @Override
            public void onClick(View v) { //뒤로가기 클릭 했을경우
                //버튼 클릭 시 발생할 이벤트내용
                switch (back_check){
                    case 1:
                        mainActivity.changeFragment(R.id.main_layout,mainActivity.now_first_desc_fragment);
                        break;
                    case 2:
                        mainActivity.changeFragment(R.id.main_layout,mainActivity.now_second_desc_fragment);
                        break;
                    case 3:
                        mainActivity.changeFragment(R.id.main_layout,mainActivity.future_first_desc_fragment);
                        break;
                    case 4:
                        mainActivity.changeFragment(R.id.main_layout,mainActivity.future_second_desc_fragment);
                        break;
                }

            }
        });


            //돈 입력받는 텍스트
            EditText numberText = (EditText)v.findViewById(R.id.input_money);
            EditText confirmtext = (EditText)v.findViewById(R.id.input_confirm);
            confirmtext.setPrivateImeOptions("defaultInputmode=korean; ");

            //투자하기 버튼을 눌렀을 경우
            Button button1 = (Button) v.findViewById(R.id.go_finish) ;
            button1.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try { //숫자말고 다른 것을 입력할때 튕기는것을 방지
                        if ( (Integer.parseInt(numberText.getText().toString()) <= now_money) && (isInteger(numberText.getText().toString()) == true) && (Integer.parseInt(numberText.getText().toString()) > 0) ) { //나중에 DB값으로 바꾸기************
                            ok_money = 1;
//                    Log.d("숫자입력", "숫자 완료");
                        }
                    }
                    catch(NumberFormatException e){
                        Toast myToast = Toast.makeText(getActivity(),"투자금액을 제대로 입력해주세요", Toast.LENGTH_SHORT);
                        ok_money = 0;
                        myToast.show();
                    }

                    if ( confirmtext.getText().toString().equals("aaa")) { //나중에 동의함으로 수정
                        //동의함이 들어오면
                        ok_confirm = 1;
//                    Log.d("입력", "동의함 완료 완료");
                    }
                    else{
                        ok_confirm = 0;
                        Log.d("입력", confirmtext.getText().toString());
                    }

                    //모든걸 잘 입력하면
                    if (ok_money == 1 && ok_confirm == 1){
                        ok_money = 0;
                        ok_confirm = 0;
                        now_money = now_money - Integer.parseInt(numberText.getText().toString());
                        items.add(new Item(total_info_c,address_c,money_info,numberText.getText().toString() + "만원"));
                        numberText.getText().clear();
                        confirmtext.getText().clear();
                        mainActivity.changeFragment(R.id.main_layout,mainActivity.invest_finish_Fragment);
//                    Log.d("입력", "완전히 완료");
                    }
                    //한개라도 잘못입력하면
                    else{
                        if(ok_money == 0){
                            Toast myToast = Toast.makeText(getActivity(),"투자금액을 제대로 입력해주세요", Toast.LENGTH_SHORT);
                            myToast.show();
                        }
                        else if(ok_confirm ==0){
                            Toast myToast = Toast.makeText(getActivity(),"동의함을 정확히 입력해주세요", Toast.LENGTH_SHORT);
                            myToast.show();
                        }
                        else if(ok_money ==0 && ok_confirm ==0){
                            Toast myToast = Toast.makeText(getActivity(),"투자금액 및 동의함을 정확히 입력해주세요", Toast.LENGTH_SHORT);
                            myToast.show();

                        }
                    }
                }
            });


            numberText.addTextChangedListener(new TextWatcher() { //나중에 입력하고 나서 경고문 뜨게 하고 싶을때 하기※※※※※※※※※※※
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable arg0) {
                    // 입력이 끝났을 때
                    try {
                        if(arg0.toString() != null || arg0.toString().trim() != ""){
                            double oper = rating * 0.01 *10000 * Integer.parseInt(arg0.toString()) ;
                            calc_money.setText(String.valueOf((int)oper) + "원");
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        Log.d("HHHHHHHHHH","EEEEEEEEEEEEEEEEEEEE");
                    }
                }
            });
        //---
        return v;
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}
