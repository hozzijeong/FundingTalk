package com.fundingtalk.fundingtalk.Main.Loan.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fundingtalk.fundingtalk.AppHelper.Loan_BaseFragment;
import com.fundingtalk.fundingtalk.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Loan_Base_Info_Fragment extends Loan_BaseFragment implements View.OnClickListener {

    @BindView(R.id.loan_user_name_et) EditText name;
    @BindView(R.id.loan_user_birth_et) EditText birth;
    @BindView(R.id.loan_user_phone_et) EditText phone;
    @BindView(R.id.loan_user_mail_et) EditText mail;
    @BindView(R.id.loan_specific_btn) Button next_page;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.loan01_base_info_fragment,container,false);
        ButterKnife.bind(this,v);
        next_page.setOnClickListener(this);
        name.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.loan_specific_btn:
                loanActivity.changeFragment(R.id.loan_main_layout,loanActivity.loan_specific_info_fragment);
                break;

        }
    }
}
