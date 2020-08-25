package com.fundingtalk.fundingtalk.Main.Investment.Fragment;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

public class RecyclerDeco extends RecyclerView.ItemDecoration { //recyclerview들의 간격 조정하는 함수!!!!!!!!!!!!

    private final int divHeight;


    public RecyclerDeco(int divHeight) {
        this.divHeight = divHeight;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount() - 1)

            outRect.bottom = divHeight;

    }
}

