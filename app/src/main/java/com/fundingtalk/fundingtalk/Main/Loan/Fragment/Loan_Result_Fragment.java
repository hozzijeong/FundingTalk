package com.fundingtalk.fundingtalk.Main.Loan.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fundingtalk.fundingtalk.AppHelper.Loan_BaseFragment;
import com.fundingtalk.fundingtalk.R;

import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Loan_Result_Fragment extends Loan_BaseFragment {

    @BindView(R.id.result_cost_rate) TextView cost_rate;
    @BindView(R.id.result_cost_result) TextView cost_result;
    @BindView(R.id.result_cost_and_ltv) TextView cost_and_ltv;
    @BindView(R.id.result_on_login) LinearLayout onLogin;
    @BindView(R.id.result_no_login) LinearLayout noLogin;
    @BindView(R.id.result_next_btn) Button next_btn;
    DecimalFormat form;
    DecimalFormat form2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.loan03_result_fragment,container,false);
        ButterKnife.bind(this,v);
        form = new DecimalFormat("#.##");
        form2 = new DecimalFormat("###,###");
        if(!Loan_Specific_Info_Fragment.counsel_state){

        }else{

        }
        return v;
    }


    private void onLogin(){
        cost_result.setText("가능 금액: "+form2.format(Loan_Specific_Info_Fragment.pos_cost)+" 만원");
        cost_rate.setText("금리: "+form.format(Loan_Specific_Info_Fragment.rate)+"% ");

        onLogin.setVisibility(View.VISIBLE);
        noLogin.setVisibility(View.INVISIBLE);
        next_btn.setText("대출 진행하기");
    }
        
    private void offLogin(){
        onLogin.setVisibility(View.INVISIBLE);
        noLogin.setVisibility(View.VISIBLE);
        next_btn.setText("메인으로 돌아가기");
    }
}
