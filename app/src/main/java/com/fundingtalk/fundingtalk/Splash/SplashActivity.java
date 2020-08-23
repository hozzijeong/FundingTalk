package com.fundingtalk.fundingtalk.Splash;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.fundingtalk.fundingtalk.AppHelper.BaseActivity;
import com.fundingtalk.fundingtalk.Main.MainActivity;
import com.fundingtalk.fundingtalk.R;

public class SplashActivity extends BaseActivity {
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Log.d("박민선","SplashActivity");

        SharedPreferences sp = getSharedPreferences("manual_state",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){ // SharedPreference : 첫 실행 때만 메뉴얼이 나오도록 설정.

                if(sp.getBoolean("isNotFirst",false)) {
                    changeActivity(context,MainActivity.class);
                    finish(); // 스플래쉬 화면은 종료시킴
                }
                else {
                    changeActivity(context,ManualActivity.class);
                    editor.putBoolean("isNotFirst",true);
                    editor.apply();
                    finish(); // 스플래쉬 화면은 종료시킴
                }
            }
        },3000); // 3초동안 스플래쉬 화면 노출
    }
}