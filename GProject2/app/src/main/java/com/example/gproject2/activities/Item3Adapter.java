package com.example.gproject2.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gproject2.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Item3Adapter extends RecyclerView.Adapter<Item3Adapter.ViewHolder>
        implements OnListsItem3ClickListener {

    ArrayList<Item3> items = new ArrayList<>();
    OnListsItem3ClickListener listener;
    int layoutType = 0;

    //ViewHolder가 초기화 될 때 혹은 ViewHolder를 초기화 할 때 실행되는 메서드
    @NonNull
    @Override
    public Item3Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.fragment3_item, viewGroup, false);

        return new Item3Adapter.ViewHolder(itemView, this, layoutType);
    }

    @Override
    public void onBindViewHolder(@NonNull Item3Adapter.ViewHolder viewHolder, int position) {
        Item3 item = items.get(position);
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


    public void addItem(Item3 item) {
        items.add(item);
    }

    public void setItems(ArrayList<Item3> items) { this.items = items; }

    public Item3 getItem(int position) {
        return items.get(position);
    }

    public void setOnItemClickListener(OnListsItem3ClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick3(Item3Adapter.ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick3(holder, view, position);
        }
    }

    public void switchLayout(int position) {
        layoutType = position;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout layout3_1;
        ImageView imageView;
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;

        public ViewHolder(View itemView, final OnListsItem3ClickListener listener, int layoutType) { // 뷰홀더 생성자로 전달되는 뷰 객체 참조하기
            super(itemView);

            // 뷰 객체에 들어있는 텍스트뷰 참조하기
            layout3_1 = itemView.findViewById(R.id.layout3_1);
            imageView = itemView.findViewById(R.id.imageview3_cardV);
            textView1 = itemView.findViewById(R.id.textView3_card1); // 장소/그룹 이름
            textView2 = itemView.findViewById(R.id.textView3_card2_1); // 종목
            textView3 = itemView.findViewById(R.id.textView3_card3); // 주소
            textView4 = itemView.findViewById(R.id.textView3_card4); // 시간
            textView5 = itemView.findViewById(R.id.textView3_card5); // 요일


            textView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null) {
                        listener.onItemClick3(Item3Adapter.ViewHolder.this, view, position);
                    }
                }
            });
            setLayoutType(layoutType);
        }

        public void setItem(Item3 item){
            imageView.setImageResource(item.getImage());
            textView1.setText(item.getTitle());
            textView2.setText(item.getCategory());
            textView3.setText(item.getAddress());
            textView4.setText(item.getTime());
            textView5.setText(item.getDay());
        }

        public void setLayoutType(int layoutType) {
        }
    }
}
