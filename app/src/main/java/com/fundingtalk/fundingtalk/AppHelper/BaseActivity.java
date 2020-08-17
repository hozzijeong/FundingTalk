package com.fundingtalk.fundingtalk.AppHelper;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class BaseActivity extends AppCompatActivity {

    protected FragmentManager fm;

    public BaseActivity(){
        this.fm = getSupportFragmentManager();
    }

    public void changeFragment(int resource,Fragment fragment){
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(resource,fragment);
        ft.commit();
    }

    public void changeActivity(Context context, Class cls){
        Intent intent = new Intent(context,cls);
        startActivity(intent);
    }
}
