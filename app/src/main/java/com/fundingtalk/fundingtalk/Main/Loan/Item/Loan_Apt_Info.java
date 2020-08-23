package com.fundingtalk.fundingtalk.Main.Loan.Item;

public class Loan_Apt_Info {
    public long real_cost; // 아파트 실제 가격
    public String ltv; // 적용 가능한 최대 ltv;
    public String apt_name; // 아파트 전체 이름
    public long pos_cost; // 대출 가능 금액
    public Double min_ltv; // 최소 LTV를 저장하는 변수
    public double rate; // 대출 금리를 저장하는 변수
    public Loan_Apt_Info(long real_cost, String ltv) {
        this.real_cost = real_cost;
        this.ltv = ltv;
    }
}
