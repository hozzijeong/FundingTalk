package com.fundingtalk.fundingtalk.Main.ETC.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fundingtalk.fundingtalk.AppHelper.Main_BaseFragment;
import com.fundingtalk.fundingtalk.Main.ETC.Adapter.notice_adapter;
import com.fundingtalk.fundingtalk.Main.ETC.Adapter.notice_data;
import com.fundingtalk.fundingtalk.Main.ETC.Adapter.qna_adapter;
import com.fundingtalk.fundingtalk.Main.MainActivity;
import com.fundingtalk.fundingtalk.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class etc_qna_fragment extends Main_BaseFragment {
    private RecyclerView recyclerview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.etc_qna_fragment, container, false);
        //--
        super.onCreate(savedInstanceState);

        recyclerview = v.findViewById(R.id.qnaview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false));
        List<qna_adapter.Item> data = new ArrayList<>();

        qna_adapter.Item invests = new qna_adapter.Item(qna_adapter.HEADER, "투자관련");
        invests.invisibleChildren = new ArrayList<>();
        invests.invisibleChildren.add(new qna_adapter.Item(qna_adapter.CHILD, "Q. P2P 투자란 무엇인가요?"));
        invests.invisibleChildren.add(new qna_adapter.Item(qna_adapter.CHILD, "Q. 원금 보장되나요?"));
        invests.invisibleChildren.add(new qna_adapter.Item(qna_adapter.CHILD, "Q. 최소 투자 금액은 얼마인가요?"));
        invests.invisibleChildren.add(new qna_adapter.Item(qna_adapter.CHILD, "Q. 투자하는 방법은 어떻게 되나요?"));
        invests.invisibleChildren.add(new qna_adapter.Item(qna_adapter.CHILD, "Q. 펀딩톡 전용 가상계좌는 무엇인가요?"));
        invests.invisibleChildren.add(new qna_adapter.Item(qna_adapter.CHILD, "Q. 모집금액이 모집되지 않아도 펀딩이 되나요?"));



        qna_adapter.Item loans = new qna_adapter.Item(qna_adapter.HEADER, "대출관련");
        loans.invisibleChildren = new ArrayList<>();
        loans.invisibleChildren.add(new qna_adapter.Item(qna_adapter.CHILD, "Q. 펀딩톡과 일반 금융권의 대출은 어떤 차이가 있나요?"));
        loans.invisibleChildren.add(new qna_adapter.Item(qna_adapter.CHILD, "Q. 대출심사 신청요건은 무엇인가요?"));
        loans.invisibleChildren.add(new qna_adapter.Item(qna_adapter.CHILD, "Q. 대출신청시 어떤 서류를 제출해야 하나요?"));
        loans.invisibleChildren.add(new qna_adapter.Item(qna_adapter.CHILD, "Q. 대출신청은 어떻게 하나요?"));
        loans.invisibleChildren.add(new qna_adapter.Item(qna_adapter.CHILD, "Q. 대출금리, 기간, 금액은 어떻게 되나요?"));
        loans.invisibleChildren.add(new qna_adapter.Item(qna_adapter.CHILD, "Q. 중도상환은 가능한가요?"));



        qna_adapter.Item guitar = new qna_adapter.Item(qna_adapter.HEADER, "기타");
        guitar.invisibleChildren = new ArrayList<>();
        guitar.invisibleChildren.add(new qna_adapter.Item(qna_adapter.CHILD, "회원가입은 어떻게 하나요?"));
        guitar.invisibleChildren.add(new qna_adapter.Item(qna_adapter.CHILD, "본인인증은 왜 필요하나요?"));
        guitar.invisibleChildren.add(new qna_adapter.Item(qna_adapter.CHILD, "개인정보 변경은 어떻게 하나요?"));
        guitar.invisibleChildren.add(new qna_adapter.Item(qna_adapter.CHILD, "가상계좌는 어디에서 발급 받나요?"));
//        guitar.invisibleChildren.add(new qna_adapter.Item(qna_adapter.CHILD, "가상계좌에 예치된 금액을 출금받을 수 있나요?"));
//        guitar.invisibleChildren.add(new qna_adapter.Item(qna_adapter.CHILD, "미성년자도 투자가 되나요?"));

        data.add(invests);
        data.add(loans);
        data.add(guitar);

        recyclerview.setAdapter(new qna_adapter(data));

        //---
        return v;
    }
}
