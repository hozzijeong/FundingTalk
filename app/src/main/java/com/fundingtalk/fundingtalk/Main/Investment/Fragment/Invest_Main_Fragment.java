package com.fundingtalk.fundingtalk.Main.Investment.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fundingtalk.fundingtalk.AppHelper.Main_BaseFragment;
import com.fundingtalk.fundingtalk.Main.Investment.Decriptions.*;
import com.fundingtalk.fundingtalk.Main.MainActivity;
import com.fundingtalk.fundingtalk.R;

import java.util.Arrays;
import java.util.List;

public class Invest_Main_Fragment extends Main_BaseFragment {

    private item_recyclerview_adapter adapter1;
    private item_recyclerview_adapter adapter2;
    private item_recyclerview_adapter adapter3;
    private RecyclerView recyclerView1;
    private RecyclerView recyclerView2;
    private RecyclerView recyclerView3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main01_invest_fragment,container,false);

        //---
        recyclerView1 = v.findViewById(R.id.now_invest_items);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView1.setLayoutManager(linearLayoutManager);

        adapter1 = new item_recyclerview_adapter();
        recyclerView1.setAdapter(adapter1);

        adapter1.setOnItemClickListener(new item_recyclerview_adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                // TODO : 아이템 클릭 이벤트를 MainActivity에서 처리.
                Log.d("이동", String.valueOf(position));
                if(position == 0){
                    Intent intent = new Intent(v.getContext(), now_First_desc.class);
                    startActivity(intent);//액티비티 띄우기
                }
                if(position == 1){
                    Intent intent = new Intent(v.getContext(), now_Second_desc.class);
                    startActivity(intent);//액티비티 띄우기
                }
            }
        }) ;

        now_getData();

        //이까지가 모집중인 상품

        recyclerView2 = v.findViewById(R.id.future_invest_items);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.getActivity());
        recyclerView2.setLayoutManager(linearLayoutManager2);

        adapter2 = new item_recyclerview_adapter();
        recyclerView2.setAdapter(adapter2);

        adapter2.setOnItemClickListener(new item_recyclerview_adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                // TODO : 아이템 클릭 이벤트를 MainActivity에서 처리.
//                Log.d("이동", String.valueOf(position));
                //클릭하면 페이지 이동
                if(position == 0){
                    Intent intent = new Intent(v.getContext(), future_First_desc.class);
                    startActivity(intent);//액티비티 띄우기
                }
                if(position == 1){
                    Intent intent = new Intent(v.getContext(), future_Second_desc.class);
                    startActivity(intent);//액티비티 띄우기
                }
            }

        }) ;

        future_getData();

        //이까지가 오픈예정

        recyclerView3 = v.findViewById(R.id.past_invest_items);

        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this.getActivity());
        recyclerView3.setLayoutManager(linearLayoutManager3);

        adapter3 = new item_recyclerview_adapter();
        recyclerView3.setAdapter(adapter3);

        past_getData();

        //이까지가 마감된 상품

        return v;
    }

    private void now_getData() { //현재진행중인 상품 정보추가

        String now_name[] = getResources().getStringArray(R.array.now_name);
        String now_month[] = getResources().getStringArray(R.array.now_month);
        String now_money[] = getResources().getStringArray(R.array.now_money);
        String now_rate[] = getResources().getStringArray(R.array.now_rate);
        String now_desc[] = getResources().getStringArray(R.array.now_desc);

        List<Integer> listResId = Arrays.asList(
                R.drawable.testimg,
                R.drawable.testimg
        );
        for (int i = 0; i < now_name.length; i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            recyclerview_item data = new recyclerview_item();

            data.setIcon(listResId.get(i));
            data.setname(now_name[i]);
            data.setrate(now_rate[i]);
            data.setmonth(now_month[i]);
            data.setmoney(now_money[i]);
            data.setdescription(now_desc[i]);

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter1.addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter1.notifyDataSetChanged();
    }

    private void future_getData() { //미래에 상품 정보추가

        String future_name[] = getResources().getStringArray(R.array.future_name);
        String future_month[] = getResources().getStringArray(R.array.future_month);
        String future_money[] = getResources().getStringArray(R.array.future_money);
        String future_rate[] = getResources().getStringArray(R.array.future_rate);
        String future_desc[] = getResources().getStringArray(R.array.future_desc);

        List<Integer> listResId = Arrays.asList(
                R.drawable.testimg,
                R.drawable.testimg
        );
        for (int i = 0; i < future_name.length; i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            recyclerview_item data = new recyclerview_item();

            data.setIcon(listResId.get(i));
            data.setname(future_name[i]);
            data.setrate(future_rate[i]);
            data.setmonth(future_month[i]);
            data.setmoney(future_money[i]);
            data.setdescription(future_desc[i]);

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter2.addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter2.notifyDataSetChanged();
    }

    private void past_getData() { //과거의 상품 정보추가

        String past_name[] = getResources().getStringArray(R.array.past_name);
        String past_month[] = getResources().getStringArray(R.array.past_month);
        String past_money[] = getResources().getStringArray(R.array.past_money);
        String past_rate[] = getResources().getStringArray(R.array.past_rate);
        String past_desc[] = getResources().getStringArray(R.array.past_desc);

        List<Integer> listResId = Arrays.asList(
                R.drawable.testimg,
                R.drawable.testimg,
                R.drawable.testimg
        );
        for (int i = 0; i < past_name.length; i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            recyclerview_item data = new recyclerview_item();

            data.setIcon(listResId.get(i));
            data.setname(past_name[i]);
            data.setrate(past_rate[i]);
            data.setmonth(past_month[i]);
            data.setmoney(past_money[i]);
            data.setdescription(past_desc[i]);

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter3.addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter3.notifyDataSetChanged();
    }

}
