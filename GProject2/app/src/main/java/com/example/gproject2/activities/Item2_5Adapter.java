package com.example.gproject2.activities;
/*
 * LinksAdapter.java 설명
 * 카드뷰형식처럼 리스트 형태로 보일때, 각각의 아이템은 뷰로 만들어지며, 각각의 아이템을 위한 뷰는 뷰 홀더에 담아두게 된다.
 * 리사이클러뷰는 선택 위젯이기 때문에, 어댑터가 데이터 관리와 뷰 객체 관리를 담당한다.
 * 리사이클러뷰 : 껍데기 역할
 * >> 이 뷰홀더 역할을 하는 클래스를 LinksAdapter 클래스 안에 넣어둔다고 생각하면 된다.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gproject2.R;

import java.util.ArrayList;
//import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Item2_5Adapter extends RecyclerView.Adapter<Item2_5Adapter.ViewHolder>
                            implements OnListsItemClickListener {

    ArrayList<Item2_5> items = new ArrayList<>();
    OnListsItemClickListener listener;
    int layoutType = 0;

    //ViewHolder가 초기화 될 때 혹은 ViewHolder를 초기화 할 때 실행되는 메서드
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.fragment2_5_item, viewGroup, false);

        return new ViewHolder(itemView, this, layoutType);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Item2_5 item = items.get(position);
        viewHolder.setItem(item); // 현재 item에 맞는 data만 설정
        viewHolder.setLayoutType(layoutType);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    // ArrayList 안의 전체 item의 개수
    // 어댑터에서 관리하는 아이템개수 반환
    //이 메서드가 ArrayList<Lists>에 들어있는 Lists 개수만큼 카운트해줌
    //이게 있어야 ArrayList<Lists>에 넣어준 Lists의 데이터를 모두 그릴수 있음


    public void addItem(Item2_5 item) {
        items.add(item);
    }

    public void setItems(ArrayList<Item2_5> items) { this.items = items; }

    public Item2_5 getItem(int position) {
        return items.get(position);
    }

    public void setOnItemClickListener(OnListsItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    public void switchLayout(int position) {
        layoutType = position;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout layout1;
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;

        public ViewHolder(View itemView, final OnListsItemClickListener listener, int layoutType) { // 뷰홀더 생성자로 전달되는 뷰 객체 참조하기
            super(itemView);

            // 뷰 객체에 들어있는 텍스트뷰 참조하기
            layout1 = itemView.findViewById(R.id.layout1);
            imageView = itemView.findViewById(R.id.imageview_cardV);
            textView1 = itemView.findViewById(R.id.textView_card1);
            textView2 = itemView.findViewById(R.id.textView_card2);
            textView3 = itemView.findViewById(R.id.textView_card3);
            textView4 = itemView.findViewById(R.id.textView_card4);
            textView5 = itemView.findViewById(R.id.textView_card5);


            textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
            setLayoutType(layoutType);
        }

        public void setItem(Item2_5 item){
            imageView.setImageResource(item.getImage());
            textView1.setText(item.getTitle());
            textView2.setText(item.getCategory());
            textView3.setText(item.getAddress());
            textView4.setText(item.getPhone());
            textView5.setText(item.getState());
        }

        public void setLayoutType(int layoutType) {
        }
    }

}
