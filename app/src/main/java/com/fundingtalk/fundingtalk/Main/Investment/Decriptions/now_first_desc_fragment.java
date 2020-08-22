package com.fundingtalk.fundingtalk.Main.Investment.Decriptions;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fundingtalk.fundingtalk.AppHelper.Main_BaseFragment;
import com.fundingtalk.fundingtalk.R;

public class now_first_desc_fragment extends Main_BaseFragment {

    private TextView address;
    private TextView pro_percent;
    private TextView pro_month;
    private TextView pro_money;
    private TextView ing_percent;
    private TextView pro_first_input;
    private TextView pro_second_input;
    private TextView pro_third_input;
    private TextView pro_fourth_input;
    private TextView pro_fifth_input;
    private TextView pro_gamjung_input;
    private TextView desc;
    private TextView loan_info_input;
    private TextView funding_info_input;
    private TextView nakchal_input;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.now_first_desc_fragment,container,false);

        address = (TextView) v.findViewById(R.id.address);
        pro_percent = (TextView) v.findViewById(R.id.pro_percent);
        pro_month = (TextView) v.findViewById(R.id.pro_month);
        pro_money = (TextView) v.findViewById(R.id.pro_money);
        ing_percent = (TextView) v.findViewById(R.id.ing_percent);
        pro_first_input = (TextView) v.findViewById(R.id.pro_first_input);
        pro_second_input = (TextView) v.findViewById(R.id.pro_second_input);
        pro_third_input = (TextView) v.findViewById(R.id.pro_third_input);
        pro_fourth_input = (TextView) v.findViewById(R.id.pro_fourth_input);
        pro_fifth_input = (TextView) v.findViewById(R.id.pro_fifth_input);
        pro_gamjung_input = (TextView) v.findViewById(R.id.pro_gamjung_input);
        desc = (TextView) v.findViewById(R.id.desc);
        loan_info_input = (TextView) v.findViewById(R.id.loan_info_input);
        funding_info_input = (TextView) v.findViewById(R.id.funding_info_input);
        nakchal_input = (TextView) v.findViewById(R.id.nakchal_input);

        setaddress("경기도 고양시 덕양구 화정동 달빛 3단지 신안 301동");
        setpro_percent("9.9%");
        setpro_month("12개월");
        setpro_money("0.3억");
        seting_percent("현재 진행중 (78%)");
        setpro_first_input("만기일시상환");
        setpro_second_input("가계자금");
        setpro_third_input("근저당권");
        setpro_fourth_input("84.87 (약 25.67평)");
        setpro_fifth_input("83.78%");
        setpro_gamjung_input("37,000만원");
        setdesc("감정가는 KB부동산시세외 일반거래가 37,000만원 및 국토교통부\\n 최근실거래가(최근6개월)의 변화 추이동을 반영하여 적용되었습니다.");
        setloan_info_input("2억 8,000만원 (원금)");
        setfunding_info_input("3,000만원 (원금)");
        setnakchal_input("본 담보가 위치한 경기도 고양시 덕양구의 최근 6개월 낙찰가율은 102%입닏.");

        return v;
    }



    public void setaddress(String a){ address.setText(a); }
    public void setpro_percent(String a){ pro_percent.setText(a); }
    public void setpro_month(String a){ pro_month.setText(a); }
    public void setpro_money(String a){ pro_money.setText(a); }
    public void seting_percent(String a){ ing_percent.setText(a); }
    public void setpro_first_input(String a){ pro_first_input.setText(a); }
    public void setpro_second_input(String a){ pro_second_input.setText(a); }
    public void setpro_third_input(String a){ pro_third_input.setText(a); }
    public void setpro_fourth_input(String a){ pro_fourth_input.setText(a); }
    public void setpro_fifth_input(String a){ pro_fifth_input.setText(a); }
    public void setpro_gamjung_input(String a){ pro_gamjung_input.setText(a); }
    public void setdesc(String a){ desc.setText(a); }
    public void setloan_info_input(String a){loan_info_input.setText(a); }
    public void setfunding_info_input(String a){ funding_info_input.setText(a); }
    public void setnakchal_input(String a){ nakchal_input.setText(a); }


    public String getaddress() { return (String) this.address.getText(); }
    public String getpro_percent() { return (String) this.pro_percent.getText() ; }
    public String getpro_month() { return (String) this.pro_month.getText() ; }
    public String getpro_money() { return (String) this.pro_money.getText() ; }
    public String geting_percent() { return (String) this.ing_percent.getText() ; }
    public String getpro_first_input() { return (String) this.pro_first_input.getText() ; }
    public String getpro_second_input() { return (String) this.pro_second_input.getText() ; }
    public String getpro_third_input() { return (String) this.pro_third_input.getText() ; }
    public String getpro_fourth_input() { return (String) this.pro_fourth_input.getText() ; }
    public String getpro_fifth_input() { return (String) this.pro_fifth_input.getText() ; }
    public String getpro_gamjung_input() { return (String) this.pro_gamjung_input.getText() ; }
    public String getdesc() { return (String) this.desc.getText() ; }
    public String getloan_info_input() { return (String) this.loan_info_input.getText() ; }
    public String getfunding_info_input() { return (String) this.funding_info_input.getText() ; }
    public String getnakchal_input() { return (String) this.nakchal_input.getText() ; }

}
