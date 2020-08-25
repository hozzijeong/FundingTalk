package com.fundingtalk.fundingtalk.Main.Custom.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fundingtalk.fundingtalk.AppHelper.BaseActivity;
import com.fundingtalk.fundingtalk.AppHelper.Main_BaseFragment;
import com.fundingtalk.fundingtalk.Login.LoginActivity;
import com.fundingtalk.fundingtalk.Main.MainActivity;
import com.fundingtalk.fundingtalk.R;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Custom_Notlogin_Fragment extends Main_BaseFragment {
    public Custom_Notlogin_Fragment custom_notlogin_fragment;
    public Custom_Main_Fragment custom_main_fragment;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main03_custom_notlogin_fragment,container,false);
        Button button = (Button) v.findViewById(R.id.go_to_login_Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 로그인 버튼을 누르면 로그인 액티비티로 이동
                mainActivity.changeActivity(mainActivity, LoginActivity.class);
                mainActivity.finish();
                // changeFragment : Custom_Notlogin_Fragment -> Custom_Main_Fragment
            }
        });
        return v;
    }
}