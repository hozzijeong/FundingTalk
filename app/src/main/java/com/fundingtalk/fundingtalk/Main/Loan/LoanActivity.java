package com.fundingtalk.fundingtalk.Main.Loan;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.fundingtalk.fundingtalk.AppHelper.BaseActivity;
import com.fundingtalk.fundingtalk.Main.Loan.Fragment.Loan_Base_Info_Fragment;
import com.fundingtalk.fundingtalk.Main.Loan.Fragment.Loan_Result_Fragment;
import com.fundingtalk.fundingtalk.Main.Loan.Fragment.Loan_Specific_Info_Fragment;
import com.fundingtalk.fundingtalk.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoanActivity extends BaseActivity{

    public Loan_Base_Info_Fragment loan_base_info_fragment;
    public Loan_Specific_Info_Fragment loan_specific_info_fragment;
    public Loan_Result_Fragment loan_result_fragment;

    @BindView(R.id.loan_main_layout) ConstraintLayout mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);
        ButterKnife.bind(this);
        setFragment();
        changeFragment(R.id.loan_main_layout,loan_base_info_fragment);
    }

    private void setFragment(){
        loan_base_info_fragment = new Loan_Base_Info_Fragment();
        loan_specific_info_fragment = new Loan_Specific_Info_Fragment();
        loan_result_fragment = new Loan_Result_Fragment();
    }

}