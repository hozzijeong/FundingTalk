package com.fundingtalk.fundingtalk.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fundingtalk.fundingtalk.AppHelper.BaseActivity;
import com.fundingtalk.fundingtalk.Main.MainActivity;
import com.fundingtalk.fundingtalk.R;

public class LoginActivity extends BaseActivity {
    EditText ed_id, ed_pw;
    String string_id, string_pw;
    public static Boolean login_state = false;
    int errorcount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ed_id = (EditText) findViewById(R.id.editTextTextEmailAddress);
        ed_pw = (EditText) findViewById(R.id.editTextTextPassword2);
        //아이디 비번 틀린횟수 카운트


        //아이디 비번 저장도니거 불러오기
        String[] id = getResources().getStringArray(R.array.id);
        String[] ps = getResources().getStringArray(R.array.ps);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                string_id = ed_id.getText().toString();
                string_pw = ed_pw.getText().toString();
                // '로그인하기' -> 투자 페이지로(이동할 페이지는 임의로 설정.) 이동
                if(string_id == id[0] && string_pw == ps[0]) {
                    login_state = true;
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                // 아이디 혹은 비밀번호가 틀렸을 경우, 토스트 띄우기
                else {
                    Toast myToast = Toast.makeText(getApplicationContext(),"현재 입력하신 아이디가 등록되어 있지 않거나, 아이디 또는 비밀번호를 잘못 입력 하셨습니다.\n 비밀번호 오류 횟수 :" + errorcount +"\n 비밀번호 5회 이상 오류 시 본인 인증을 통해 비밀번호를 변경하여야 로그인 가능합니다.", Toast.LENGTH_SHORT);
                    myToast.show();
                    errorcount++;
                }
            }
        });
    }

    // 왼쪽 상단 화살표 버튼 누를 시 실행되는 함수.
    //public void BackButtonClicked(View v) {
    //    Intent intent = new Intent(getApplicationContext(), com.fundingtalk.fundingtalk.Main.Investment.Fragment.Invest_Main_Fragment.class);
    //    finish();
    //}
}

