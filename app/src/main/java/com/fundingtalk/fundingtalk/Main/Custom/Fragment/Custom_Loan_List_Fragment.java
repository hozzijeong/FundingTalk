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
import com.fundingtalk.fundingtalk.Main.Custom.Adapter.RecyclerDeco;
import com.fundingtalk.fundingtalk.Main.Custom.Item.Item;
import com.fundingtalk.fundingtalk.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Custom_Loan_List_Fragment extends Main_BaseFragment implements View.OnClickListener {

    @BindView(R.id.loan_list) RecyclerView loan_list;
    @BindView(R.id.loan_return_back) Button back;
    @BindView(R.id.custom_loan_return_count) TextView count;
    private RecyclerDeco deco;
    ArrayList<Item> items;
    RecyclerAdapter adapter;
    LinearLayoutManager linearLayoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.custom_loan_return_fragment,container,false);
        ButterKnife.bind(this,v);
        items = new ArrayList<>();
        linearLayoutManager = new LinearLayoutManager(mainActivity);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        loan_list.setLayoutManager(linearLayoutManager);
        deco = new RecyclerDeco(20);
        loan_list.addItemDecoration(deco);
        adapter = new RecyclerAdapter(mainActivity,items);
        loan_list.setAdapter(adapter);
        return v;
    }

    private void setItems(){
        String total_info = "연 9.7% 12개월";
        String address = "경기도 성남시 수정구 수진도 세일띠아모아파트";
        String money_info = "대출 금액";
        String money = "3000 만원";
        items.add(new Item(total_info,address,money_info,money));
        count.setText("총 "+items.size()+"개");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.loan_return_back:
                mainActivity.removeFragment(this);
                break;
        }
    }
}
