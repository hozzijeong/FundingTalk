package com.fundingtalk.fundingtalk.Main.Investment.Fragment;
import android.graphics.drawable.Drawable;

public class recyclerview_item {

    private Drawable iconDrawable ;
    private String invest_rate ;
    private String invest_month ;
    private String invest_money ;
    private String invest_description ;

    public void setIcon(Drawable icon) {
        iconDrawable = icon ;
    }
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

    public Drawable getIcon() {
        return this.iconDrawable ;
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