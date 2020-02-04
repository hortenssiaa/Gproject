package com.example.lifecycle;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    TextView textView;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.counter);
        b1 = (Button)findViewById(R.id.plus);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                textView.setText("현재 개수="+ count);
            }
        });

        b2 = (Button)findViewById(R.id.minus);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                textView.setText("현재 개수="+count);
            }
        });

        if(savedInstanceState != null){
            count = savedInstanceState.getInt("count");
            textView.setText("현재 개수="+count);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LifeCycle", "onStart() 호출");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LifeCycle", "onResume() 호출");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LifeCycle", "onPause() 호출");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LifeCycle", "onStop() 호출");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LifeCycle", "onDestroy() 호출");
    }
}
