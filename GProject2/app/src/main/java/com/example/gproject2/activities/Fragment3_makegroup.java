package com.example.gproject2.activities;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gproject2.R;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class Fragment3_makegroup extends Fragment {
    private static final String TAG = "Fragment3_makegroup";
    public static final int MODE_INSERT = 1;
    public static final int MODE_MODIFY = 2;

    int mMode = MODE_INSERT;
    int _id = -1;

    Context context;

    @Override
    public void onAttach(@NonNull Context context) {
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment3_makegroup, container, false);

        initUI(rootView);

        return rootView;
    }

    private void initUI(ViewGroup rootView) {
        Button saveButton = rootView.findViewById(R.id.makegroup_save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mMode == MODE_INSERT) {
                    saveGroup();
                } else if (mMode == MODE_MODIFY) {
                    modifyGroup();
                }
                ((MainActivity) getActivity()).onFragmentChanged(12);
            }
        });

        Button closeButton = rootView.findViewById(R.id.makegroup_close);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity) getActivity()).onFragmentChanged(12);
            }
        });
    }

    private void saveGroup() {
        String sql = "insert into " + GroupDatabase.TABLE_GROUP +
                "(IMAGE, TITLE, CATEGORY, ADDRESS, TIME, DAY) values (" +
                "'" + picturePath +
    }

    private void modifyGroup() {
    }
}
