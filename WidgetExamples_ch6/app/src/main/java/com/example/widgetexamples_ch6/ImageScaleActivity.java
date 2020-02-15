package com.example.widgetexamples_ch6;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ImageScaleActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyImageView(this));
    }

}
