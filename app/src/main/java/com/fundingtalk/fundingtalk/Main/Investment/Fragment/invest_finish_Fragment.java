package com.fundingtalk.fundingtalk.Main.Investment.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fundingtalk.fundingtalk.AppHelper.Main_BaseFragment;
import com.fundingtalk.fundingtalk.R;

public class invest_finish_Fragment extends Main_BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.invest_finish_fragment, container, false);

        Button button2 = (Button) v.findViewById(R.id.goto_custom) ; //마이페이지 가는 버튼 구현
        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.changeFragment(R.id.main_layout,mainActivity.invest_main_fragment);
            }
        });

        return v;
    }
}

