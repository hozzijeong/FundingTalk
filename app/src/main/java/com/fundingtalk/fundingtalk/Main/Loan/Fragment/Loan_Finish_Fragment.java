package com.fundingtalk.fundingtalk.Main.Loan.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fundingtalk.fundingtalk.AppHelper.Loan_BaseFragment;
import com.fundingtalk.fundingtalk.Main.MainActivity;
import com.fundingtalk.fundingtalk.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Loan_Finish_Fragment extends Loan_BaseFragment {
    @BindView(R.id.loan_finish_back) Button back;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.loan04_finish_fragment,container,false);
        ButterKnife.bind(this,v);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loanActivity.changeActivity(loanActivity, MainActivity.class);
                loanActivity.finish();
            }
        });

        return v;
    }
}
