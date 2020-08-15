package com.fundingtalk.fundingtalk.Main.Investment.Fragment;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fundingtalk.fundingtalk.Main.Investment.Decriptions.First_desc;
import com.fundingtalk.fundingtalk.R;

import java.util.ArrayList;

public class item_recyclerview_adapter extends RecyclerView.Adapter<item_recyclerview_adapter.ItemViewHolder> {

    // adapter에 들어갈 list 입니다.
    private ArrayList<recyclerview_item> listData = new ArrayList<>();

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater를 이용하여 전 단계에서 만들었던 item.xml을 inflate 시킵니다.
        // return 인자는 ViewHolder 입니다.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.invest_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // Item을 하나, 하나 보여주는(bind 되는) 함수입니다.
        holder.onBind(listData.get(position));
    }

    @Override
    public int getItemCount() {
        // RecyclerView의 총 개수 입니다.
        return listData.size();
    }

    void addItem(recyclerview_item data) {
        // 외부에서 item을 추가시킬 함수입니다.
        listData.add(data);
    }

    // RecyclerView의 핵심인 ViewHolder 입니다.
    // 여기서 subView를 setting 해줍니다.
    class ItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView rate;
        private TextView month;
        private TextView money;
        private TextView desc;
        private int count = 0;


        ItemViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            rate = itemView.findViewById(R.id.invest_rating);
            month = itemView.findViewById(R.id.invest_month);
            money = itemView.findViewById(R.id.invest_money);
            desc = itemView.findViewById(R.id.invest_description);

            //클릭 이벤트
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO : process click event.
                    Log.d("hasdg","wlketngwlekjt");
                }
            });
        }

        void onBind(recyclerview_item data) {
            imageView.setImageResource(data.getIcon());
            rate.setText(data.getrate());
            month.setText(data.getmonth());
            money.setText(data.getmoney());
            desc.setText(data.getdescription());

        }

    }
}
