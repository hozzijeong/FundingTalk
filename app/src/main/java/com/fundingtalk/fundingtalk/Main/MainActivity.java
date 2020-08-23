package com.fundingtalk.fundingtalk.Main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.fundingtalk.fundingtalk.AppHelper.BaseActivity;
import com.fundingtalk.fundingtalk.Main.Custom.Fragment.Custom_Main_Fragment;
import com.fundingtalk.fundingtalk.Main.ETC.Fragment.Etc_Main_Fragment;
import com.fundingtalk.fundingtalk.Main.Investment.Decriptions.future_first_desc_fragment;
import com.fundingtalk.fundingtalk.Main.Investment.Decriptions.future_second_desc_fragment;
import com.fundingtalk.fundingtalk.Main.Investment.Decriptions.now_first_desc_fragment;
import com.fundingtalk.fundingtalk.Main.Investment.Decriptions.now_second_desc_fragment;
import com.fundingtalk.fundingtalk.Main.Investment.Fragment.Invest_Main_Fragment;
import com.fundingtalk.fundingtalk.Main.Investment.Fragment.invest_finish_Fragment;
import com.fundingtalk.fundingtalk.Main.Investment.Fragment.invest_input_file_Fragment;
import com.fundingtalk.fundingtalk.Main.Loan.Fragment.Loan_Main_Fragment;
import com.fundingtalk.fundingtalk.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    public Custom_Main_Fragment custom_main_fragment;
    public Invest_Main_Fragment invest_main_fragment;
    public Loan_Main_Fragment loan_main_fragment;
    public Etc_Main_Fragment etc_main_fragment;
    public invest_input_file_Fragment invest_input_file_Fragment;
    public invest_finish_Fragment invest_finish_Fragment;

    public now_first_desc_fragment now_first_desc_fragment;
    public now_second_desc_fragment now_second_desc_fragment;
    public future_first_desc_fragment future_first_desc_fragment;
    public future_second_desc_fragment future_second_desc_fragment;

    @BindView(R.id.main_bottom_navi) BottomNavigationView bottom_navi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setFragment();
        //bottom_navigation 을 클릭했을 때, 페이지 변경을 위한 이벤트 처리
        bottom_navi.setOnNavigationItemSelectedListener(this);

        changeFragment(R.id.main_layout,invest_main_fragment);

    }

    protected void setFragment(){
        //Fragment 들을 객체화(초기화) 시키는 메소드
        custom_main_fragment = new Custom_Main_Fragment();
        invest_main_fragment = new Invest_Main_Fragment();
        loan_main_fragment = new Loan_Main_Fragment();
        etc_main_fragment = new Etc_Main_Fragment();
        invest_input_file_Fragment = new invest_input_file_Fragment();
        invest_finish_Fragment = new invest_finish_Fragment();

        now_first_desc_fragment = new now_first_desc_fragment();
        now_second_desc_fragment = new now_second_desc_fragment();
        future_first_desc_fragment = new future_first_desc_fragment();
        future_second_desc_fragment = new future_second_desc_fragment();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // bottom navigation 의 이벤트 처리 리스너
        switch (menuItem.getItemId()){
            case R.id.main_invest:
                // 투자하기로 이동(fragment)
                changeFragment(R.id.main_layout,invest_main_fragment);
                return true;
            case R.id.main_loan:
                //대출 받기로 이동
                changeFragment(R.id.main_layout,loan_main_fragment);
                return true;
            case R.id.main_custom:
                // 개인 정보로 이동
                changeFragment(R.id.main_layout,custom_main_fragment);
                return true;
            case R.id.main_faq:
                // faq로 이동
                changeFragment(R.id.main_layout,etc_main_fragment);
                return true;

            default:return false;
        }

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

}