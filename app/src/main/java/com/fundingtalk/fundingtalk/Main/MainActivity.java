package com.fundingtalk.fundingtalk.Main;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.fundingtalk.fundingtalk.AppHelper.BaseActivity;
import com.fundingtalk.fundingtalk.Main.Custom.Fragment.Custom_Main_Fragment;
import com.fundingtalk.fundingtalk.Main.Investment.Fragment.Invest_Main_Fragment;
import com.fundingtalk.fundingtalk.Main.Loan.Fragment.Loan_Main_Fragment;
import com.fundingtalk.fundingtalk.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    public Custom_Main_Fragment custom_main_fragment;
    public Invest_Main_Fragment invest_main_fragment;
    public Loan_Main_Fragment loan_main_fragment;

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
            case R.id.main_menu:
                // 메뉴 설정으로 이동
                return true;

            default:return false;
        }

    }
}