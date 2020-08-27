package com.fundingtalk.fundingtalk.Main.Custom.Item;

import android.util.Log;

public class Item {

    public Item(String total_info, String address, String money_info, String money) {
        this.total_info = total_info;
        this.address = address;
        this.money_info = money_info;
        this.money = money;
    }

    public String getAddress() {
        return address;
    }

    public String getMoney() {
        return money;
    }

    public String getMoney_info() {
        return money_info;
    }

    public String getTotal_info() {
        return total_info;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public void setMoney_info(String money_info) {
        this.money_info = money_info;
    }

    public void setTotal_info(String total_info) {
        this.total_info = total_info;
    }

    public void addmoney(String money_input){
//        Log.d("heyefjkwebtnkjw", money.substring(1,4));
        money = String.valueOf(Integer.parseInt(money) + Integer.parseInt(money_input));
//        money = String.valueOf(Integer.parseInt(money.substring(0,5)) + Integer.parseInt(money_input.substring(0,4)));
    }

    public String total_info;
    public String address;
    public String money_info;
    public String money;
}
