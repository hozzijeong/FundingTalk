package com.fundingtalk.fundingtalk.AppHelper;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.fundingtalk.fundingtalk.Main.MainActivity;

public class Main_BaseFragment extends Fragment {
    protected MainActivity mainActivity;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // 변수 mainActivity 를 사용해서, MainActivity 에 있는 메소드 등에 접근 가능.
        mainActivity = (MainActivity) this.getActivity();
    }
}
