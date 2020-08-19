package com.fundingtalk.fundingtalk.AppHelper;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.fundingtalk.fundingtalk.Splash.ManualActivity;

public class Manual_BaseFragment extends Fragment {
    protected ManualActivity manualActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // 변수 mainActivity 를 사용해서, MainActivity 에 있는 메소드 등에 접근 가능.
        manualActivity = (ManualActivity) this.getActivity();
    }
}
