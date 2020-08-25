package com.fundingtalk.fundingtalk.Main.Custom.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fundingtalk.fundingtalk.AppHelper.Main_BaseFragment;
import com.fundingtalk.fundingtalk.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Custom_Invest_Fragment extends Main_BaseFragment implements View.OnClickListener {
    /*
        2020.08.21 에 할일
        1. 마이페이지 프래그먼트 전환 시 사라지는 오류 해결
        2. 투자/ 대출 관련 리싸이클러뷰 어댑터 생성 후 연결
        3. 마이페이지 이미지 씌우기
        4. 로그인 기능? 구현할 거 있으면 구현하기
        5. 대출 마지막 페이지 생성 및 디자인
     */
    @BindView(R.id.custom_invest_list) Button invest_list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.custom_invest_fragment,container,false);
        ButterKnife.bind(this,v);
        invest_list.setOnClickListener(this);
        return  v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.custom_invest_list:
                    mainActivity.addFragment(R.id.main_layout,mainActivity.invest_list_fragment);
                break;
        }
    }
}
