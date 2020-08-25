package com.fundingtalk.fundingtalk.Main.Custom.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fundingtalk.fundingtalk.Main.Custom.Item.Item;
import com.fundingtalk.fundingtalk.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<Item> arrayList;
    int item_layout;
    public RecyclerAdapter(Context context,ArrayList<Item> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recycle_item,null);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.total_info.setText(arrayList.get(position).total_info);
        holder.address.setText(arrayList.get(position).address);
        holder.money_info.setText(arrayList.get(position).money_info);
        holder.money.setText(arrayList.get(position).money);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView total_info;
        TextView address;
        TextView money_info;
        TextView money;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            total_info = itemView.findViewById(R.id.custom_pro_info);
            address = itemView.findViewById(R.id.custom_pro_address);
            money_info = itemView.findViewById(R.id.custom_total_tv);
            money = itemView.findViewById(R.id.custom_total_cost);
        }
    }
}
