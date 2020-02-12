package com.example.widgetexamples_ch6;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SingleTouchActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SingleTouchView v = new SingleTouchView(this, null);
        setContentView(v);
    }

}