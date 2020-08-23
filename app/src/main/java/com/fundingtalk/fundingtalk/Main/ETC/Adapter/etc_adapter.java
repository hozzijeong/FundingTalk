package com.fundingtalk.fundingtalk.Main.ETC.Adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.fundingtalk.fundingtalk.AppHelper.BaseActivity;
import com.fundingtalk.fundingtalk.AppHelper.Main_BaseFragment;
import com.fundingtalk.fundingtalk.Main.Custom.Fragment.Custom_Invest_Fragment;
import com.fundingtalk.fundingtalk.Main.Custom.Fragment.Custom_Loan_Fragment;
import com.fundingtalk.fundingtalk.Main.ETC.Fragment.etc_notice_fragment;
import com.fundingtalk.fundingtalk.Main.ETC.Fragment.etc_qna_fragment;

import java.util.ArrayList;

public class etc_adapter extends FragmentStatePagerAdapter {
    ArrayList<Main_BaseFragment> fragments = new ArrayList<Main_BaseFragment>();

    int pageCount;
    public etc_adapter(FragmentManager fm , int behavior) {
        super(fm);
        this.pageCount = behavior;
        fragments.add(new etc_qna_fragment());
        fragments.add(new etc_notice_fragment());
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                etc_qna_fragment tab1 = new etc_qna_fragment();
                return tab1;
            case 1:
                etc_notice_fragment tab2 = new etc_notice_fragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

}

