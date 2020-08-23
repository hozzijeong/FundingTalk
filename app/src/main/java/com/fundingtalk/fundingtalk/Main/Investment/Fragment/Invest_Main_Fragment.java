package com.fundingtalk.fundingtalk.Main.Investment.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fundingtalk.fundingtalk.AppHelper.Main_BaseFragment;
import com.fundingtalk.fundingtalk.R;

public class Invest_Main_Fragment extends Main_BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main01_invest_fragment,container,false);

        mainActivity.changeFragment(R.id.main_layout,mainActivity.invest_main_fragment);
        return v;
    }
}
