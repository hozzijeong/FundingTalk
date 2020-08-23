package com.fundingtalk.fundingtalk.Main.Custom.Adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.fundingtalk.fundingtalk.Main.Custom.Fragment.Custom_Invest_Fragment;
import com.fundingtalk.fundingtalk.Main.Custom.Fragment.Custom_Loan_Fragment;

public class Custom_Tab_Adapter extends FragmentStatePagerAdapter {

    int pageCount;
    public Custom_Tab_Adapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.pageCount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Log.d("TAG","getItem: "+position);
                return new Custom_Invest_Fragment();
            case 1:
                Log.d("TAG","getItem: "+position);
                return new Custom_Loan_Fragment();
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return (pageCount !=0)?pageCount:0;
    }
}
