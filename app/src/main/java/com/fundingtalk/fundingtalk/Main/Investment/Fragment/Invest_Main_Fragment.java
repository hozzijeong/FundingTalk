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
import com.fundingtalk.fundingtalk.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Invest_Main_Fragment extends Main_BaseFragment {

    static public int back_page = 0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ArrayList<item_recyclerview_adapter> adapters = new ArrayList<item_recyclerview_adapter>();
        ArrayList<RecyclerView> recyclerviews = new ArrayList<RecyclerView>();
        ArrayList<LinearLayoutManager> LinearLayoutManagers = new ArrayList<LinearLayoutManager>();

        View v = inflater.inflate(R.layout.main01_invest_fragment,container,false);

        recyclerviews.add(v.findViewById(R.id.now_invest_items));
        recyclerviews.add(v.findViewById(R.id.future_invest_items));
        recyclerviews.add(v.findViewById(R.id.past_invest_items));

        adapters.add(new item_recyclerview_adapter());
        adapters.add(new item_recyclerview_adapter());
        adapters.add(new item_recyclerview_adapter());

        LinearLayoutManagers.add(new LinearLayoutManager(this.getActivity()));
        LinearLayoutManagers.add(new LinearLayoutManager(this.getActivity()));
        LinearLayoutManagers.add(new LinearLayoutManager(this.getActivity()));

        recyclerviews.get(0).setLayoutManager(LinearLayoutManagers.get(0));
        recyclerviews.get(1).setLayoutManager(LinearLayoutManagers.get(1));
        recyclerviews.get(2).setLayoutManager(LinearLayoutManagers.get(2));

        recyclerviews.get(0).setAdapter(adapters.get(0));
        recyclerviews.get(1).setAdapter(adapters.get(1));
        recyclerviews.get(2).setAdapter(adapters.get(2));

        RecyclerDeco spaceDecoration = new RecyclerDeco(1);
        recyclerviews.get(0).addItemDecoration(spaceDecoration);
        recyclerviews.get(1).addItemDecoration(spaceDecoration);
        recyclerviews.get(2).addItemDecoration(spaceDecoration);

        //---
//        recyclerView1 = v.findViewById(R.id.now_invest_items);
//
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
//        recyclerView1.setLayoutManager(linearLayoutManager);
//
//        adapter1 = new item_recyclerview_adapter();
//        recyclerView1.setAdapter(adapter1);

        adapters.get(0).setOnItemClickListener(new item_recyclerview_adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
            // TODO : 아이템 클릭 이벤트를 MainActivity에서 처리.
                Log.d("이동", String.valueOf(position));
                if(position == 0){
//                    Intent intent = new Intent(v.getContext(), invest_input_file.class);
//                    startActivity(intent);//액티비티 띄우기
                    back_page = 1;
                    mainActivity.changeFragment(R.id.main_layout,mainActivity.now_first_desc_fragment);
                }
                if(position == 1){
                    back_page = 2;
                    mainActivity.changeFragment(R.id.main_layout,mainActivity.now_second_desc_fragment);
                }
            }
        }) ;

//이까지가 모집중인 상품

        adapters.get(1).setOnItemClickListener(new item_recyclerview_adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
            // TODO : 아이템 클릭 이벤트를 MainActivity에서 처리.
            // Log.d("이동", String.valueOf(position));
            //클릭하면 페이지 이동
                if(position == 0){
                    mainActivity.changeFragment(R.id.main_layout,mainActivity.future_first_desc_fragment);
                }
                if(position == 1){
                    mainActivity.changeFragment(R.id.main_layout,mainActivity.future_second_desc_fragment);
                }
            }

        }) ;
//이까지가 오픈예정

        //----
        List<Integer> listResId = Arrays.asList(
                R.drawable.invest_n1,
                R.drawable.invest_n2
        );
        for (int i = 0; i < listResId.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            recyclerview_item data = new recyclerview_item();

            data.setIcon(listResId.get(i));

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapters.get(0).addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapters.get(0).notifyDataSetChanged();

        List<Integer> listResId2 = Arrays.asList(
                R.drawable.invest_f1,
                R.drawable.invest_f2,
                R.drawable.invest_f3
        );
        for (int i = 0; i < listResId2.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            recyclerview_item data = new recyclerview_item();

            data.setIcon(listResId2.get(i));

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapters.get(1).addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapters.get(1).notifyDataSetChanged();

        List<Integer> listResId3 = Arrays.asList(
                R.drawable.invest_p1,
                R.drawable.invest_p2,
                R.drawable.invest_p3
        );
        for (int i = 0; i < listResId3.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            recyclerview_item data = new recyclerview_item();

            data.setIcon(listResId3.get(i));

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapters.get(2).addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapters.get(2).notifyDataSetChanged();

        //------
        return v;
    }
}
