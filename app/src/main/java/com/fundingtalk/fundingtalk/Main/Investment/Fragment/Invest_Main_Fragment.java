package com.fundingtalk.fundingtalk.Main.Investment.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fundingtalk.fundingtalk.AppHelper.Main_BaseFragment;
import com.fundingtalk.fundingtalk.R;

import java.util.Arrays;
import java.util.List;

public class Invest_Main_Fragment extends Main_BaseFragment {

    private item_recyclerview_adapter adapter;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main01_invest_fragment,container,false);
        recyclerView = v.findViewById(R.id.invest_items);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new item_recyclerview_adapter();
        recyclerView.setAdapter(adapter);

        getData();

        return v;
    }

    private void getData() {
        // 임의의 데이터입니다.
        List<String> listrate = Arrays.asList("국화", "사막", "수국", "해파리", "코알라", "등대", "펭귄", "튤립",
                "국화", "사막", "수국", "해파리", "코알라", "등대", "펭귄", "튤립");

        List<String> listmonth = Arrays.asList(
                "이 꽃은 국화입니다.",
                "여기는 사막입니다.",
                "이 꽃은 수국입니다.",
                "이 동물은 해파리입니다.",
                "이 동물은 코알라입니다.",
                "이것은 등대입니다.",
                "이 동물은 펭귄입니다.",
                "이 꽃은 튤립입니다.",
                "이 꽃은 국화입니다.",
                "여기는 사막입니다.",
                "이 꽃은 수국입니다.",
                "이 동물은 해파리입니다.",
                "이 동물은 코알라입니다.",
                "이것은 등대입니다.",
                "이 동물은 펭귄입니다.",
                "이 꽃은 튤립입니다."
        );

        List<String> listmoney = Arrays.asList(
                "이 꽃은 국화입니다.1",
                "여기는 사막입니다.1",
                "이 꽃은 수국입니다.1",
                "이 동물은 해파리입니다.1",
                "이 동물은 코알라입니다.1",
                "이것은 등대입니다.1",
                "이 동물은 펭귄입니다.1",
                "이 꽃은 튤립입니다.1",
                "이 꽃은 국화입니다.1",
                "여기는 사막입니다.1",
                "이 꽃은 수국입니다.1",
                "이 동물은 해파리입니다.1",
                "이 동물은 코알라입니다.1",
                "이것은 등대입니다.1",
                "이 동물은 펭귄입니다.1",
                "이 꽃은 튤립입니다.1"
        );

        List<String> listdesc = Arrays.asList(
                "설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다",
                "설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다",
                "설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다",
                "설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다",
                "설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다",
                "설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다",
                "설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다",
                "설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다",
                "설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다",
                "설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다",
                "설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다",
                "설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다",
                "설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다",
                "설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다",
                "설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다",
                "설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다설명입니다"
        );

        List<Integer> listResId = Arrays.asList(
                R.drawable.testimg,
                R.drawable.testimg,
                R.drawable.testimg,
                R.drawable.testimg,
                R.drawable.testimg,
                R.drawable.testimg,
                R.drawable.testimg,
                R.drawable.testimg,
                R.drawable.testimg,
                R.drawable.testimg,
                R.drawable.testimg,
                R.drawable.testimg,
                R.drawable.testimg,
                R.drawable.testimg,
                R.drawable.testimg,
                R.drawable.testimg
        );
        for (int i = 0; i < listrate.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            recyclerview_item data = new recyclerview_item();

            data.setIcon(listResId.get(i));
            data.setrate(listrate.get(i));
            data.setmonth(listmonth.get(i));
            data.setmoney(listmoney.get(i));
            data.setdescription(listdesc.get(i));

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();
    }
}
