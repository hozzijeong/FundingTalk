package com.fundingtalk.fundingtalk.Splash;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fundingtalk.fundingtalk.R;

public class Fragment3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("박민선","Fragment3");
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment3,container,false);
        return rootView;
    }
}