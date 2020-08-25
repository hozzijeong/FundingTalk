package com.fundingtalk.fundingtalk.AppHelper;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BaseActivity extends AppCompatActivity {

    protected FragmentManager fm;

    public BaseActivity(){
        this.fm = getSupportFragmentManager();
    }

    public void changeFragment(int resource,Fragment fragment){
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(resource,fragment);
        ft.commit();
    }

    public void addFragment(int resource,Fragment fragment){
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(resource,fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void removeFragment(Fragment fragment){
        FragmentTransaction ft = fm.beginTransaction();
        ft.remove(fragment);
        ft.commit();
    }


    public void changeActivity(Context context, Class cls){
        Intent intent = new Intent(context,cls);
        startActivity(intent);
    }

    public void show_Log(String data){
        Log.d("LOG",data);
    }

    //상세설명 페이지 구현할때 필요한 메소드 - invest

//    private TextView address = (TextView) findViewById(R.id.address);
//    private TextView pro_percent = (TextView) findViewById(R.id.pro_percent);
//    private TextView pro_month = (TextView) findViewById(R.id.pro_month);
//    private TextView pro_money = (TextView) findViewById(R.id.pro_money);
//    private TextView ing_percent = (TextView) findViewById(R.id.ing_percent);
//    private TextView pro_first_input = (TextView) findViewById(R.id.pro_first_input);
//    private TextView pro_second_input = (TextView) findViewById(R.id.pro_second_input);
//    private TextView pro_third_input = (TextView) findViewById(R.id.pro_third_input);
//    private TextView pro_fourth_input = (TextView) findViewById(R.id.pro_fourth_input);
//    private TextView pro_fifth_input = (TextView) findViewById(R.id.pro_fifth_input);
//    private TextView pro_gamjung_input = (TextView) findViewById(R.id.pro_gamjung_input);
//    private TextView desc = (TextView) findViewById(R.id.desc);
//    private TextView loan_info_input = (TextView) findViewById(R.id.loan_info_input);
//    private TextView funding_info_input = (TextView) findViewById(R.id.funding_info_input);
//    private TextView nakchal_input = (TextView) findViewById(R.id.nakchal_input);
//
//    public void setaddress(String a){ address.setText(a); }
//    public void setpro_percent(String a){ pro_percent.setText(a); }
//    public void setpro_month(String a){ pro_month.setText(a); }
//    public void setpro_money(String a){ pro_money.setText(a); }
//    public void seting_percent(String a){ ing_percent.setText(a); }
//    public void setpro_first_input(String a){ pro_first_input.setText(a); }
//    public void setpro_second_input(String a){ pro_second_input.setText(a); }
//    public void setpro_third_input(String a){ pro_third_input.setText(a); }
//    public void setpro_fourth_input(String a){ pro_fourth_input.setText(a); }
//    public void setpro_fifth_input(String a){ pro_fifth_input.setText(a); }
//    public void setpro_gamjung_input(String a){ pro_gamjung_input.setText(a); }
//    public void setdesc(String a){ desc.setText(a); }
//    public void setloan_info_input(String a){loan_info_input.setText(a); }
//    public void setfunding_info_input(String a){ funding_info_input.setText(a); }
//    public void setnakchal_input(String a){ nakchal_input.setText(a); }
//
//
//    public String getaddress() { return (String) this.address.getText(); }
//    public String getpro_percent() { return (String) this.pro_percent.getText() ; }
//    public String getpro_month() { return (String) this.pro_month.getText() ; }
//    public String getpro_money() { return (String) this.pro_money.getText() ; }
//    public String geting_percent() { return (String) this.ing_percent.getText() ; }
//    public String getpro_first_input() { return (String) this.pro_first_input.getText() ; }
//    public String getpro_second_input() { return (String) this.pro_second_input.getText() ; }
//    public String getpro_third_input() { return (String) this.pro_third_input.getText() ; }
//    public String getpro_fourth_input() { return (String) this.pro_fourth_input.getText() ; }
//    public String getpro_fifth_input() { return (String) this.pro_fifth_input.getText() ; }
//    public String getpro_gamjung_input() { return (String) this.pro_gamjung_input.getText() ; }
//    public String getdesc() { return (String) this.desc.getText() ; }
//    public String getloan_info_input() { return (String) this.loan_info_input.getText() ; }
//    public String getfunding_info_input() { return (String) this.funding_info_input.getText() ; }
//    public String getnakchal_input() { return (String) this.nakchal_input.getText() ; }
}
