package com.fundingtalk.fundingtalk.Main.Investment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fundingtalk.fundingtalk.Main.Investment.Fragment.Invest_Main_Fragment;
import com.fundingtalk.fundingtalk.Main.MainActivity;
import com.fundingtalk.fundingtalk.R;

public class invest_finish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invest_finish);

        //메인으로 버튼을 눌렀을 경우
        Button button1 = (Button) findViewById(R.id.goto_main) ;
        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);//액티비티 띄우기
            }
        });

//        Button button2 = (Button) findViewById(R.id.goto_custom) ; //마이페이지 가는 버튼 구현
//        button1.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);//액티비티 띄우기
//            }
//        });
    }
}