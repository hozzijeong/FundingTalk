package com.fundingtalk.fundingtalk.AppHelper;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.fundingtalk.fundingtalk.Main.Loan.LoanActivity;

public class Loan_BaseFragment extends Fragment {

    protected LoanActivity loanActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        loanActivity = (LoanActivity) getActivity();
    }
}
