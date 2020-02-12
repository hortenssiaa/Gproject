package com.example.widgetexamples_ch6;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /*
        called when the activity is first started.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VolumControlview volumControlview = (VolumControlview) findViewById(R.id.volumeControl);
        volumControlview.setKnobListener(new VolumControlview.KnobListener() {
            @Override
            public void onChanged(double angle) {
                if(angle > 0)
                    ;
                else
                    ;
            }
        });
    }
}
