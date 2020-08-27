package com.fundingtalk.fundingtalk.Main.Loan.Fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;

import com.fundingtalk.fundingtalk.AppHelper.Loan_BaseFragment;
import com.fundingtalk.fundingtalk.Login.LoginActivity;
import com.fundingtalk.fundingtalk.Main.MainActivity;
import com.fundingtalk.fundingtalk.R;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Loan_Result_Fragment extends Loan_BaseFragment implements View.OnClickListener {

    @BindView(R.id.result_address_tv) TextView address_tv;
    @BindView(R.id.result_cost_rate) TextView cost_rate;
    @BindView(R.id.result_cost_result) TextView cost_result;
    @BindView(R.id.result_cost_and_ltv) TextView cost_and_ltv;
    @BindView(R.id.result_user_name)TextView user_name;
    @BindView(R.id.result_onlogin) Group onLogin;
    @BindView(R.id.result_offlogin) Group noLogin;
    @BindView(R.id.result_next_btn) Button next_btn;
    @BindView(R.id.result_check1) CheckBox check1;
    @BindView(R.id.result_check2) CheckBox check2;
    @BindView(R.id.result_check3) CheckBox check3;
    @BindView(R.id.result_check_all) CheckBox check_all;
    @BindView(R.id.result_offlog_info2) TextView offlog;
    DecimalFormat form;
    DecimalFormat form2;
    String name;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.loan03_result_fragment,container,false);
        ButterKnife.bind(this,v);
        next_btn.setOnClickListener(this);
        setSpan();
        form = new DecimalFormat("#.##");
        form2 = new DecimalFormat("###,###");
        address_tv.setText(Loan_Specific_Info_Fragment.loan_apt_info.apt_name);
        if(LoginActivity.login_state){
            onLogin();
        }else{
            offLogin();
        }
        // 상담 상태에 따라서도 변경되는 창을 만들어 놓을 것.
        check_all.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                check1.setChecked(true);
                check2.setChecked(true);
                check3.setChecked(true);
            }
        });
        return v;
    }
    private void setSpan(){
        Spannable[] span = new Spannable[3];
        span[0] = (Spannable) check1.getText();
        span[1] = (Spannable) check2.getText();
        span[2] = (Spannable) check3.getText();
        Spannable spannable = (Spannable) offlog.getText();

        span[0].setSpan(new ForegroundColorSpan(Color.parseColor("#5A75D7")),16,20,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span[1].setSpan(new ForegroundColorSpan(Color.parseColor("#5A75D7")),21,25,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span[2].setSpan(new ForegroundColorSpan(Color.parseColor("#5A75D7")),22,26,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(Color.parseColor("#5A75D7")),11,15,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(new ForegroundColorSpan(Color.parseColor("#5A75D7")),19,22,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
    }
    @SuppressLint("SetTextI18n")
    private void onLogin(){
        name = "최승현";
        user_name.setText(name+"님의 대출 가능 금액입니다.");

        cost_result.setText(form2.format(Loan_Specific_Info_Fragment.loan_apt_info.pos_cost)+" 만원");
        cost_rate.setText("대출 금리: "+form.format(Loan_Specific_Info_Fragment.loan_apt_info.rate)+"% ");
        cost_and_ltv.setText("펀딩톡 감정가: "+
                form2.format(Loan_Specific_Info_Fragment.loan_apt_info.real_cost)+"만원 /"
        +"적용 LTV: "+Loan_Specific_Info_Fragment.loan_apt_info.apply_ltv+"%");

        onLogin.setVisibility(View.VISIBLE);
        noLogin.setVisibility(View.INVISIBLE);
        next_btn.setText("대출 신청하기");
    }
    @SuppressLint("SetTextI18n")
    private void offLogin(){
        name = "고객님";
        user_name.setText(name+"의 대출 가능 한도입니다.");
        // 로그인 됐을때랑 안됐을 때 차이를 둠
        cost_result.setText(form2.format(Loan_Specific_Info_Fragment.loan_apt_info.pos_cost)+" 만원");
        cost_rate.setText("대출 금리: "+form.format(Loan_Specific_Info_Fragment.loan_apt_info.rate)+"% ");
        cost_and_ltv.setText("펀딩톡 감정가: "+
                form2.format(Loan_Specific_Info_Fragment.loan_apt_info.real_cost)+"만원 /"
                +"LTV: "+Loan_Specific_Info_Fragment.loan_apt_info.min_ltv+"%");
        onLogin.setVisibility(View.INVISIBLE);
        noLogin.setVisibility(View.VISIBLE);
        next_btn.setText("메인으로 돌아가기");
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.result_next_btn:
                if(!LoginActivity.login_state){
                    loanActivity.changeActivity(loanActivity, MainActivity.class);
                    loanActivity.finish();
                }else{
                    if(check1.isChecked() && check2.isChecked() && check3.isChecked()){
                        loanActivity.addFragment(R.id.loan_main_layout,loanActivity.loan_finish_fragment);
                    }else{
                        Toast.makeText(loanActivity,"모두 동의해주세요.",Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }
}
