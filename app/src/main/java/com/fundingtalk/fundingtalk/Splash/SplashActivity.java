package com.fundingtalk.fundingtalk.Splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.fundingtalk.fundingtalk.AppHelper.BaseActivity;
import com.fundingtalk.fundingtalk.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Log.d("박민선","SplashActivity");

        Context context = this;

        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(context, com.fundingtalk.fundingtalk.Splash.ManualActivity.class);
                startActivity(intent); // 매뉴얼 엑티비티로 이동시킴
                Log.d("박민선","SplashActivity_after_startActivity");
                finish(); // 스플래쉬 화면은 종료시킴
            }
        },3000); // 3초동안 스플래쉬 화면 노출
    }
}