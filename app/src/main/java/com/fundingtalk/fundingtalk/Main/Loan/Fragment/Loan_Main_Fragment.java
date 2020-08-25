package com.fundingtalk.fundingtalk.Main.Loan.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.fundingtalk.fundingtalk.AppHelper.Main_BaseFragment;
import com.fundingtalk.fundingtalk.Login.LoginActivity;
import com.fundingtalk.fundingtalk.Main.Loan.LoanActivity;
import com.fundingtalk.fundingtalk.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.fundingtalk.fundingtalk.Main.Investment.Fragment.Invest_Main_Fragment.back_page;

public class Loan_Main_Fragment extends Main_BaseFragment implements View.OnClickListener {
    // MainActivity에 뿌리를 두고 있음
    @BindView(R.id.loan_go_login_btn) Button login;
    @BindView(R.id.loan_move_btn) Button move;
    @BindView(R.id.loan_base1_layout) ConstraintLayout main_layout;
    @BindView(R.id.imageView2) ImageView offLoginIv;
    @BindView(R.id.textView2) TextView offloginTv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main02_loan_fragment,container,false);
        ButterKnife.bind(this,v);
        login.setOnClickListener(this);
        move.setOnClickListener(this);
        if (LoginActivity.login_state){
            login.setEnabled(false);
        }else{
            login.setEnabled(true);
            offLogin();
        }
        return v;
    }

    private void offLogin(){
        login.setVisibility(View.VISIBLE);
        offLoginIv.setVisibility(View.VISIBLE);
        offloginTv.setVisibility(View.VISIBLE);
    }


    private void onLogin(){
        login.setVisibility(View.INVISIBLE);
        offLoginIv.setVisibility(View.INVISIBLE);
        offloginTv.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loan_go_login_btn:
                back_page = 3;
                mainActivity.changeActivity(mainActivity, LoginActivity.class);
                mainActivity.finish();
                break;
            case R.id.loan_move_btn:
                mainActivity.changeActivity(mainActivity, LoanActivity.class);
                mainActivity.finish();
                break;
        }
    }
}