package com.fundingtalk.fundingtalk.Splash;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fundingtalk.fundingtalk.AppHelper.Manual_BaseFragment;
import com.fundingtalk.fundingtalk.Main.MainActivity;
import com.fundingtalk.fundingtalk.R;

public class Fragment4 extends Manual_BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("박민선","Fragment4");
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment4,container,false);
        SharedPreferences sp = manualActivity.getSharedPreferences("manual_state", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        Button button = rootView.findViewById(R.id.startButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manualActivity.changeActivity(manualActivity,MainActivity.class);
                editor.putBoolean("manual_state",true);
                editor.commit();
                manualActivity.finish();
            }
        });

        return rootView;
    }
}