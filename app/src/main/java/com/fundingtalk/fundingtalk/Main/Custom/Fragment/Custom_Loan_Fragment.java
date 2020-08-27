package com.fundingtalk.fundingtalk.Main.Custom.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fundingtalk.fundingtalk.AppHelper.Main_BaseFragment;
import com.fundingtalk.fundingtalk.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Custom_Loan_Fragment extends Main_BaseFragment implements View.OnClickListener {
    @BindView(R.id.custom_loan_list) Button loan_list;
    @BindView(R.id.custom_copy_accNum) Button copy;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.custom_loan_fragment,container,false);
        ButterKnife.bind(this,v);
        loan_list.setOnClickListener(this);
        copy.setOnClickListener(this);
        return v;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.custom_loan_list:
                    mainActivity.addFragment(R.id.main_layout,mainActivity.loan_list_fragment);
                break;
            case R.id.custom_copy_accNum:
                Toast.makeText(mainActivity,"복사되었습니다.",Toast.LENGTH_LONG).show();
                break;
        }
    }
}
