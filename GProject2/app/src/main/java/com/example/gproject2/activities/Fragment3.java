package com.example.gproject2.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gproject2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

// 바로가기 메뉴 - 운동그룹
public class Fragment3 extends Fragment {


    RecyclerView recyclerView;
    Item3Adapter adapter;
    FloatingActionButton fab_add;

    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment3, container, false);

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
        recyclerView = rootView.findViewById(R.id.real_recyclerView3);
        fab_add = rootView.findViewById(R.id.fab_add);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    // 아래로 스크롤
                    fab_add.hide();
                } else if (dy < 0) {
                    // 위로 스크롤
                    fab_add.show();
                }
            }
        });
        recyclerView.setLayoutManager(layoutManager);

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        adapter = new Item3Adapter();

        adapter.addItem(new Item3(0, R.drawable.ic_launcher_round, "모임1", "도시근린공원",
                "서울 서초구 양재 236", "연중무휴", "02-575-3895"));
        adapter.addItem(new Item3(1, R.drawable.ic_launcher_round, "모임2", "강/하천",
                "서울 강남구 도곡동", "", ""));
        adapter.addItem(new Item3(2, R.drawable.ic_launcher_round, "모임3", "도시근린공원",
                "서울 성동구 뚝섬로 273", "연중무휴", "02-460-2905"));
        adapter.addItem(new Item3(3, R.drawable.ic_launcher_round, "모임4", "산",
                "서울 성동구 뚝섬로 273", "연중무휴", "02-460-2905"));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnListsItem3ClickListener() {
            @Override
            public void onItemClick3(Item3Adapter.ViewHolder holder, View view, int position) {
                Item3 item = adapter.getItem(position);
                Toast.makeText(getContext(), item.getTitle() + " 선택됨", Toast.LENGTH_LONG).show();
            }
        });
    }
}
