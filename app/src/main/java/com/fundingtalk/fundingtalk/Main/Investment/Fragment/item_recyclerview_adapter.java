package com.fundingtalk.fundingtalk.Main.Investment.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

    //버튼 외부 클릭 리스너
    public interface OnItemClickListener {
        void onItemClick(View v, int position) ;
    }
    private OnItemClickListener mListener = null ;

    // OnItemClickListener 리스너 객체 참조를 어댑터에 전달하는 메서드
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener ;
    }

    //-----------

    // RecyclerView의 핵심인 ViewHolder 입니다.
    // 여기서 subView를 setting 해줍니다.
    class ItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView name;
        private TextView rate;
        private TextView month;
        private TextView money;
        private TextView desc;
        private int count = 0;

        ItemViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.invest_name);
            rate = itemView.findViewById(R.id.invest_rating);
            month = itemView.findViewById(R.id.invest_month);
            money = itemView.findViewById(R.id.invest_money);
            desc = itemView.findViewById(R.id.invest_description);

            //클릭 이벤트
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition() ;
                    if (pos != RecyclerView.NO_POSITION) {
                        // TODO : use pos.
//                        recyclerview_item item = listData.get(pos) ;
//                        Log.d("hasdg", String.valueOf(pos));
                        if (mListener != null) {
                            mListener.onItemClick(v, pos) ;
                        }
                    }
                }
            });
        }

        void onBind(recyclerview_item data) {
            imageView.setImageResource(data.getIcon());
            name.setText(data.getname());
            rate.setText(data.getrate());
            month.setText(data.getmonth());
            money.setText(data.getmoney());
            desc.setText(data.getdescription());

        }

    }


}
