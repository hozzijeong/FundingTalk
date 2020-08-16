package com.fundingtalk.fundingtalk.Main.Investment.Fragment;
import android.graphics.drawable.Drawable;

//데이터 클래스

public class recyclerview_item {

    private int invest_icon;
    private String invest_name;
    private String invest_rate ;
    private String invest_month ;
    private String invest_money ;
    private String invest_description ;

    public void setIcon(int icon) {
        invest_icon = icon ;
    }
    public void setname(String name) {invest_name = name ;}
    public void setrate(String rate) {
        invest_rate = rate ;
    }
    public void setmonth(String month) {
        invest_month = month ;
    }
    public void setmoney(String money) {
        invest_money = money ;
    }
    public void setdescription(String desc) {
        invest_description = desc ;
    }

    public int getIcon() {
        return this.invest_icon ;
    }
    public String getname() {
        return this.invest_name ;
    }
    public String getrate() {
        return this.invest_rate ;
    }
    public String getmonth() {
        return this.invest_month ;
    }
    public String getmoney() {
        return this.invest_money ;
    }
    public String getdescription() {
        return this.invest_description ;
    }
}