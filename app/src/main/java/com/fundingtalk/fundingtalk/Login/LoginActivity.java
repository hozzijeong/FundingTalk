package com.fundingtalk.fundingtalk.Login;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fundingtalk.fundingtalk.AppHelper.BaseActivity;
import com.fundingtalk.fundingtalk.AppHelper.Main_BaseFragment;
import com.fundingtalk.fundingtalk.Main.Custom.Fragment.Custom_Main_Fragment;
import com.fundingtalk.fundingtalk.Main.Custom.Fragment.Custom_Notlogin_Fragment;
import com.fundingtalk.fundingtalk.Main.MainActivity;
import com.fundingtalk.fundingtalk.R;

import static com.fundingtalk.fundingtalk.Main.Investment.Fragment.Invest_Main_Fragment.back_page;
import static com.fundingtalk.fundingtalk.Main.Investment.Fragment.invest_input_file_Fragment.*;

public class LoginActivity extends BaseActivity {
    EditText ed_id, ed_pw;
    String string_id, string_pw;
    public static Boolean login_state = false;
    Context context = this;

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
                if(string_id.equals("fundingtalk") && string_pw.equals("a123456789")) {
                    login_state = true;
//                    mainActivity.changeFragment(R.id.main_layout,mainActivity.invest_main_fragment);
                    changeActivity(context,MainActivity.class);
                    //    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    //    startActivity(intent);
                    now_money = 5000;
                    now_name = "최승현";
                    Toast.makeText(context, "로그인 되었습니다.",Toast.LENGTH_LONG).show();
                    finish();
                }

                // 아이디 혹은 비밀번호가 틀렸을 경우, 토스트 띄우기
                else {
                    Toast.makeText(context,"아이디/비밀번호가 틀렸습니다.",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.top_logo)
                .setTitle("펀딩톡 종료")
                .setMessage("FundingTalk을 종료하시겠습니까?")
                .setPositiveButton("종료", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("아니요", null)
                .show();
    }

    // 왼쪽 상단 화살표 버튼 누를 시 실행되는 함수. => 로그인 프래그먼트로 이동???(안될것같음)
    public void BackButtonClicked(View v) {
        changeActivity(this, MainActivity.class);
        finish();
    }
}