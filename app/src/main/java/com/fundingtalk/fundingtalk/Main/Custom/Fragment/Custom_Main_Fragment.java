package com.fundingtalk.fundingtalk.Main.Custom.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.fundingtalk.fundingtalk.AppHelper.Main_BaseFragment;
import com.fundingtalk.fundingtalk.Main.Custom.Adapter.Custom_Tab_Adapter;
import com.fundingtalk.fundingtalk.R;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Custom_Main_Fragment extends Main_BaseFragment {

    /*
        다른 fragment 갔다가 여기로 들어오면 앞의 내용들이 다 없어짐

     */
    @BindView(R.id.tab_layout) TabLayout tabLayout;
    @BindView(R.id.custom_viewpager) ViewPager customViewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main03_custom_fragment,container,false);
        ButterKnife.bind(this,v);
        Custom_Tab_Adapter tab_adapter = new Custom_Tab_Adapter(mainActivity.getSupportFragmentManager(),2);
        customViewPager.setAdapter(tab_adapter);
        customViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        // 이게 왜 실행이 안됨...?
//        Log.d("TAG","invest: "+tab_adapter.getItem(0));
//        Log.d("TAG","loan: "+tab_adapter.getItem(1));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                customViewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
        return v;
    }
}
