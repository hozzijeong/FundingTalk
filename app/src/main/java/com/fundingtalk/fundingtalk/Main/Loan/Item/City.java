package com.fundingtalk.fundingtalk.Main.Loan.Item;

public class City {
    public String city_name;
    public long index;
    public long local_code;
    public String ltv;


    public City(String city_name,long index) {
        this.city_name = city_name;
        this.index = index;
    }

    public City(String city_name,long index, long local_code,String ltv){
        this.city_name = city_name;
        this.index = index;
        this.local_code = local_code;
        this.ltv = ltv;
    }

}
