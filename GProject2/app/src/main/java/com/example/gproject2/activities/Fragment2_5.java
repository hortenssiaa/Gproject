package com.example.gproject2.activities;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.gproject2.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

// 바로가기 메뉴 - My 운동그룹
public class Fragment2_5 extends Fragment{

    RecyclerView recyclerView;
    Item2_5Adapter adapter;

    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment2_5, container, false);

        initUI(rootView);

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        if (context != null) {
            context = null;
        }
    }

    public void initUI(ViewGroup rootView) {
        recyclerView = rootView.findViewById(R.id.real_recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new Item2_5Adapter();

        adapter.addItem(new Item2_5(0, R.drawable.ic_launcher_round, "양재 시민의 숲", "도시근린공원",
                "서울 서초구 양재 236", "연중무휴", "02-575-3895"));
        adapter.addItem(new Item2_5(1, R.drawable.ic_launcher_round, "양재천", "강/하천",
                "서울 강남구 도곡동", "", ""));
        adapter.addItem(new Item2_5(2, R.drawable.ic_launcher_round, "서울숲", "도시근린공원",
                "서울 성동구 뚝섬로 273", "연중무휴", "02-460-2905"));
        adapter.addItem(new Item2_5(3, R.drawable.ic_launcher_round, "산1", "산",
                "서울 성동구 뚝섬로 273", "연중무휴", "02-460-2905"));
        adapter.addItem(new Item2_5(4, R.drawable.ic_launcher_round, "산2", "산",
                "서울 성동구 뚝섬로 273", "연중무휴", "02-460-2905"));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnListsItemClickListener() {
            @Override
            public void onItemClick(Item2_5Adapter.ViewHolder holder, View view, int position) {
                Item2_5 item = adapter.getItem(position);
                Toast.makeText(getContext(), item.getTitle() + "아이템 선택됨", Toast.LENGTH_LONG).show();
            }
        });
    }

}


