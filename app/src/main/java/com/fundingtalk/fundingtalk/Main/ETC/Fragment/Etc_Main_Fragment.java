package com.fundingtalk.fundingtalk.Main.ETC.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.fundingtalk.fundingtalk.AppHelper.Main_BaseFragment;
import com.fundingtalk.fundingtalk.Main.ETC.Adapter.etc_adapter;
import com.fundingtalk.fundingtalk.R;
import com.google.android.material.tabs.TabLayout;

public class Etc_Main_Fragment extends Main_BaseFragment {

    private ViewPager viewPager;
    private TabLayout tabLayout2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main04_etc_fragment, container, false);

        tabLayout2=(TabLayout)v.findViewById(R.id.tabs);

        viewPager=(ViewPager)v.findViewById(R.id.viewPager);
//        viewPager.setAdapter(new etc_adapter(getChildFragmentManager()));

        etc_adapter etc_adapter = new etc_adapter(mainActivity.getSupportFragmentManager(),2);
        viewPager.setAdapter(etc_adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout2));
        tabLayout2.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }
            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });

        return v;
    }

    //-------
}