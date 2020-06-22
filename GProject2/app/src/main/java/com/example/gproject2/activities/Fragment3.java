package com.example.gproject2.activities;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.gproject2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

// 바로가기 메뉴 - 전체 운동그룹
public class Fragment3 extends Fragment {
    private static final String TAG = "Fragment3";
    public static SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM월dd일");
    public static SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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

    public void initUI(final ViewGroup rootView) {
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
                Snackbar.make(view, "새로운 운동그룹 만들기 페이지로 넘어갑니다.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                ((MainActivity) getActivity()).onFragmentChanged(13);

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

    private void println(String msg) {
        Log.d(TAG, msg);
    }
    public int loadGroupListData() {
        println("loadGroupListData called.");
        String sql = "select _id, IMAGE, TITLE, CATEGORY, ADDRESS, TIME, DAY, CREATE_DATE, MODIFY_DATE from "
                + GroupDatabase.TABLE_GROUP + " order by CREATE_DATE desc";

        int recordCount = -1;
        GroupDatabase database = GroupDatabase.getInstance(context);
        if (database != null) {
            Cursor outCursor = database.rawQuery(sql);

            recordCount = outCursor.getCount();
            println("record count : " + recordCount + "\n");

            ArrayList<Item3> items = new ArrayList<>();

            for (int i=0; i<recordCount; i++) {
                outCursor.moveToNext();

                int _id = outCursor.getInt(0);
                int image = outCursor.getInt(1);
                String title = outCursor.getString(2);
                String category = outCursor.getString(3);
                String address = outCursor.getString(4);
                String time = outCursor.getString(5);
                String day = outCursor.getString(6);
                String dateStr = outCursor.getColumnName(7);
                String createDateStr = null;
                if (dateStr != null && dateStr.length() > 10) {
                    try {
                        Date inDate = dateFormat2.parse(dateStr);
                        createDateStr = dateFormat1.format(inDate);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else {
                    createDateStr = "";
                }

                println("#" + i + " -> " + _id + ", " + image + ", " + title + ", " + category + "," + address + ", " +
                        time + ", " + day + ", " + createDateStr);
                items.add(new Item3(_id, image, title, category, address, time, day));
            }

            outCursor.close();

            adapter.setItems(items);
            adapter.notifyDataSetChanged();
        }
        return recordCount;
    }
}