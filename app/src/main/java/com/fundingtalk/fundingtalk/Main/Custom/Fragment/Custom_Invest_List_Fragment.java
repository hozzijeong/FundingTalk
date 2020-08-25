package com.fundingtalk.fundingtalk.Main.Custom.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fundingtalk.fundingtalk.AppHelper.Main_BaseFragment;
import com.fundingtalk.fundingtalk.Main.Custom.Adapter.RecyclerAdapter;
import com.fundingtalk.fundingtalk.Main.Custom.Item.Item;
import com.fundingtalk.fundingtalk.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Custom_Invest_List_Fragment extends Main_BaseFragment implements View.OnClickListener {

    @BindView(R.id.invest_list) RecyclerView invest_list;
    @BindView(R.id.invest_return_back) Button back;
    @BindView(R.id.custom_loan_return_count) TextView count;
    private RecyclerAdapter adapter;
    ArrayList<Item> items;
    LinearLayoutManager linearLayoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.custom_invest_return_fragment,container,false);
        ButterKnife.bind(this,v);
        back.setOnClickListener(this);
        items = new ArrayList<>();
        setItems();
        linearLayoutManager = new LinearLayoutManager(mainActivity);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        invest_list.setLayoutManager(linearLayoutManager);
        adapter = new RecyclerAdapter(mainActivity,items);
        invest_list.setAdapter(adapter);
        return v;
    }

    private void setItems(){
        String total_info1 = "연 9.55% 12개월";
        String address1 = "서울특별시 강남구 대치동";
        String money1= "100 만원";

        String total_info2 = "연 9.55% 12개월";
        String address2 = "대구광역시 사직동";
        String money_info = "총 투자 금액";
        String money2= "250 만원";
        items.add(new Item(total_info1,address1,money_info,money1));
        items.add(new Item(total_info2,address2,money_info,money2));

        count.setText("총 "+items.size()+"개");
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.invest_return_back:
                mainActivity.removeFragment(this);
                break;
        }
    }
}
