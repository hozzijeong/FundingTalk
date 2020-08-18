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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ed_id = (EditText) findViewById(R.id.editTextTextEmailAddress);
        ed_pw = (EditText) findViewById(R.id.editTextTextPassword2);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                string_id = ed_id.getText().toString();
                string_pw = ed_pw.getText().toString();
                // '로그인하기' -> 투자 페이지로(이동할 페이지는 임의로 설정.) 이동
                //if(string_id == 데이터 베이스에 저장된 아이디, string_pw == 해당 아이디의 비밀번호) {
                //    login_state = true;
                //    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                //    startActivity(intent);
                //    finish();
                //}

                // 아이디 혹은 비밀번호가 틀렸을 경우, 토스트 띄우기
                //else {
                //    Toast.makeText()
                //}
            }
        });
    }

    // 왼쪽 상단 화살표 버튼 누를 시 실행되는 함수.
    //public void BackButtonClicked(View v) {
    //    Intent intent = new Intent(getApplicationContext(), com.fundingtalk.fundingtalk.Main.Investment.Fragment.Invest_Main_Fragment.class);
    //    finish();
    //}
}

