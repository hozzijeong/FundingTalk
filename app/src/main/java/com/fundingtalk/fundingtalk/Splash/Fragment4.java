package com.fundingtalk.fundingtalk.Splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fundingtalk.fundingtalk.Main.MainActivity;
import com.fundingtalk.fundingtalk.R;

public class Fragment4 extends Fragment {
    ManualActivity manualActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.manualActivity = (ManualActivity) getContext();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("박민선","Fragment4");
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment4,container,false);

        Button button = rootView.findViewById(R.id.startButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(rootView.getContext(), MainActivity.class);
                startActivity(intent);
                manualActivity.finish();
            }
        });

        return rootView;
    }
}