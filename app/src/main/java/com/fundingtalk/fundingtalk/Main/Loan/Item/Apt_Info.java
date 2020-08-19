package com.fundingtalk.fundingtalk.Main.Loan.Item;

public class Apt_Info {
    public String apt_name;

    public String getApt_name() {
        return apt_name;
    }
    public long avg_cost;
    public String full_name;

    public String deal_amount;
    public String size;
    public String local_dong;

    public Apt_Info(long avg_cost,String apt_name) {
        this.avg_cost = avg_cost;
        this.full_name = apt_name;
    }
    public Apt_Info() {

    }
}
