package com.example.gproject2.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gproject2.R;

import androidx.fragment.app.Fragment;

// 바로가기 메뉴 - 운동그룹
public class Fragment3 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment3, container, false);
    }
}
