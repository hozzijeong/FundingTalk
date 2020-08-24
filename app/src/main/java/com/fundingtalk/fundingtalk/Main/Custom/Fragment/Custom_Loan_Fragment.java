package com.fundingtalk.fundingtalk.Main.Custom.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fundingtalk.fundingtalk.AppHelper.Main_BaseFragment;
import com.fundingtalk.fundingtalk.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Custom_Loan_Fragment extends Main_BaseFragment implements View.OnClickListener {
    @BindView(R.id.custom_loan_list)
    Button loan_list;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.custom_loan_fragment,container,false);
        ButterKnife.bind(this,v);
        loan_list.setOnClickListener(this);
        return v;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.custom_loan_list:
                    mainActivity.changeFragment(R.id.main_layout,mainActivity.invest_list_fragment);
                break;
        }
    }
}
