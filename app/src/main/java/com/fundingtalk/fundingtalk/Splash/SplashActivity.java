package com.fundingtalk.fundingtalk.Splash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.fundingtalk.fundingtalk.AppHelper.BaseActivity;
import com.fundingtalk.fundingtalk.Main.MainActivity;
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
            public void run(){ // SharedPreference : 첫 실행 때만 메뉴얼이 나오도록 설정.
                SharedPreferences sp = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                if(sp.contains("isFirst")) {
                    // "isFirst" 키 값이 존재하는 경우 == 첫 실행이 아닌 경우
                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                    finish(); // 스플래쉬 화면은 종료시킴
                }
                else {
                    Intent intent = new Intent(context, com.fundingtalk.fundingtalk.Splash.ManualActivity.class);
                    startActivity(intent); // 매뉴얼 엑티비티로 이동시킴

                    editor.putBoolean("isFirst",false);
                    editor.commit();
                    finish(); // 스플래쉬 화면은 종료시킴
                }
            }
        },3000); // 3초동안 스플래쉬 화면 노출
    }
}