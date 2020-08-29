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
import com.fundingtalk.fundingtalk.Main.MainActivity;
import com.fundingtalk.fundingtalk.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.fundingtalk.fundingtalk.Main.Investment.Fragment.invest_input_file_Fragment.df3;
import static com.fundingtalk.fundingtalk.Main.Investment.Fragment.invest_input_file_Fragment.now_money;

public class Custom_Invest_List_Fragment extends Main_BaseFragment implements View.OnClickListener {

    @BindView(R.id.invest_list) RecyclerView invest_list;
    @BindView(R.id.invest_return_back) Button back;
    @BindView(R.id.custom_loan_return_count) TextView count;
    private RecyclerAdapter adapter;
    private RecyclerDeco deco;
    LinearLayoutManager linearLayoutManager;

    TextView given_money;
    TextView item1;
    TextView item2;
    TextView item3;
    TextView item4;
    TextView item5;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.custom_invest_return_fragment,container,false);
        ButterKnife.bind(this,v);
        back.setOnClickListener(this);

        given_money = (TextView) v.findViewById(R.id.given_money);
        item1 = (TextView) v.findViewById(R.id.item1);
        item2 = (TextView) v.findViewById(R.id.item2);
//        item3 = (TextView) v.findViewById(R.id.item3);
        item4 = (TextView) v.findViewById(R.id.item4);
        item5 = (TextView) v.findViewById(R.id.item5);

        given_money.setText("20,194 원");
        item1.setText(String.valueOf(df3.format((850-now_money)*10000)) +" 원");
        item2.setText("27,854 원");
//        item3.setText("305640 원");
        item4.setText( "7,660 원");
        item5.setText("0 원");

        count.setText("총 "+MainActivity.items.size()+"개");
        linearLayoutManager = new LinearLayoutManager(mainActivity);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        invest_list.setLayoutManager(linearLayoutManager);

        deco = new RecyclerDeco(20);
        invest_list.addItemDecoration(deco);

        adapter = new RecyclerAdapter(mainActivity,MainActivity.items);
        invest_list.setAdapter(adapter);
        return v;
    }

    static public void setItems(){
        MainActivity.items.clear();
        String total_info1 = "연 9.55% 12개월";
        String address1 = "서울특별시 강남구 대치동";
        String money1= "100 만원";

        String total_info2 = "연 9.55% 12개월";
        String address2 = "대구광역시 사직동";
        String money_info = "총 투자 금액";
        String money2= "250 만원";
        MainActivity.items.add(new Item(total_info1,address1,money_info,money1));
        MainActivity.items.add(new Item(total_info2,address2,money_info,money2));
    }

    static public void addItems_custom(String total_info, String address, String money_info, String money){
        MainActivity.items.add(new Item(total_info,address,money_info,money));
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
