package com.fundingtalk.fundingtalk.Main.ETC.Fragment;

import android.content.Context;
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
import com.fundingtalk.fundingtalk.Main.ETC.Adapter.notice_adapter;
import com.fundingtalk.fundingtalk.Main.ETC.Adapter.notice_data;
import com.fundingtalk.fundingtalk.Main.MainActivity;
import com.fundingtalk.fundingtalk.R;

import java.util.Arrays;
import java.util.List;

public class etc_qna_fragment extends Main_BaseFragment {

    private notice_adapter adapter;
    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.etc_qna_fragment,container,false);

        init(v);

        getData();
        return v;
    }

    private void init(View v) {
        RecyclerView noticeview = v.findViewById(R.id.noticeview);
        Log.d("hehehhe2","**************************************************");

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        if(linearLayoutManager == null){
            Log.d("hehehhe","**************************************************");
        }
        else{
            Log.d("hehehhe3","**************************************************");
        }
        noticeview.setLayoutManager(linearLayoutManager);

        adapter = new notice_adapter();
        noticeview.setAdapter(adapter);
    }

    private void getData() {
        List<String> listTitle = Arrays.asList(
                "[공지사항] 펀딩톡 투자 관련 안내드립니다.",
                "펀딩톡 통합 정보 서비스 이용 약관 변경 안내",
                "펀딩톡 1:1 문의 상담 점검 안내",
                "[공지] 고객센터 채팅 상담 점검 안내 (5/23 04:00 ~ \n" +" 06:00)",
                "펀딩톡 앱 구버전 지원 중단 안내",
                "안드로이드 OS 4.4 이하 버전 업데이트 지원 중단 안내",
                "[공지] 서비스 정상 복구 공지"
        );
        List<String> listDate = Arrays.asList(
                "2020. 07. 28",
                "2020. 06. 21",
                "2020. 06. 03",
                "2020. 05. 22",
                "2020. 04. 17",
                "2020. 03. 15",
                "2020. 03. 02"
        );

        for (int i = 0; i < listTitle.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            notice_data ndata = new notice_data();
            ndata.setTitle(listTitle.get(i));
            ndata.setDate(listDate.get(i));

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(ndata);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();
    }
}
