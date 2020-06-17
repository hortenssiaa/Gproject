package com.example.gproject2.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gproject2.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListsActivity extends AppCompatActivity {
    /*
    Item2_5 fragment_list;
    Fragment2_5 fragment2_5;
    RecyclerView recyclerV;
    Item2_5Adapter adapter;
    ImageView iv_cardPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTheme(android.R.style.Theme_NoTitleBar_Fullscreen);
        setContentView(R.layout.fragment2_5_item);

        fragment_list = new Item2_5();
        fragment2_5 = new Fragment2_5();


        ArrayList<Lists> items = new ArrayList<>();
        recyclerV = findViewById(R.id.fake_recyclerView); // R.id.recyclerView

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerV.setLayoutManager(layoutManager);
        //recyclerV.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Item2_5Adapter(this, items);
        recyclerV.setAdapter(adapter);

        //GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        //recyclerView.setLayoutManager(layoutManager);
        //adapter = new LinksAdapter();

        iv_cardPhoto = (ImageView) findViewById(R.id.imageview_cardV);

        adapter.addItem(new Lists(R.drawable.ic_launcher_round, "양재 시민의 숲", "도시근린공원", "서울 서초구 양재 236", "연중무휴",
                "02-575-3895"));
        adapter.addItem(new Lists(R.drawable.ic_launcher_round,"양재천", "강/하천", "서울 강남구 도곡동", "",
                ""));

        recyclerV.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnListsItemClickListener() {
            @Override
            public void onItemClick(Item2_5Adapter.ViewHolder holder, View view, int position) {
                Lists item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "장소 선택됨: " + item.getName(),
                        Toast.LENGTH_LONG).show();
            }
        });
        recyclerV.setHasFixedSize(true);

        getSupportFragmentManager().beginTransaction().add(R.id.container, fragment2_5).commit();
        //Main화면인, R.id.container부분에(activity_main.xml에 있음) mapActivity xml 화면 보여줌

    }
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment2_5);


    }

     */
}
