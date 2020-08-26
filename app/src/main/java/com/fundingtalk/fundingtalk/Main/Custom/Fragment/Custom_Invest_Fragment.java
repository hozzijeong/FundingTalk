package com.fundingtalk.fundingtalk.Main.Custom.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fundingtalk.fundingtalk.AppHelper.Main_BaseFragment;
import com.fundingtalk.fundingtalk.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.fundingtalk.fundingtalk.Main.Investment.Fragment.invest_input_file_Fragment.now_money;
import static com.fundingtalk.fundingtalk.Main.Custom.Fragment.Custom_Invest_List_Fragment.*;
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

    TextView now_m;
    Button see_count;
    TextView set1;
    TextView set1_1;
    TextView set2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.custom_invest_fragment,container,false);
        ButterKnife.bind(this,v);
        invest_list.setOnClickListener(this);

        set1 = (TextView) v.findViewById(R.id.custom_invest_total_money_tv);
        set1.setText(String.valueOf(850-now_money) + "만원");

        set1_1 = (TextView) v.findViewById(R.id.custom_invest_total_count_tv);
        set1_1.setText("총 " + String.valueOf(items.size()) +" 건의 투자 잔액");

        set2 = (TextView) v.findViewById(R.id.custom_invest_return_tv);
        set2.setText("9.8%");

        see_count = (Button) v.findViewById(R.id.custom_invest_list);
        see_count.setText(String.valueOf(items.size()) + "건");
        now_m = (TextView) v.findViewById(R.id.custom_now_money);
        now_m.setText(String.valueOf(now_money) + "만원");

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
