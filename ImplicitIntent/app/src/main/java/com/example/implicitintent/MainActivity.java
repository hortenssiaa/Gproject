package com.example.implicitintent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        Intent intent = null;

        switch (view.getId()){
            case R.id.phonecall:
                intent = new Intent(intent.ACTION_VIEW, Uri.parse("tel:+82123456789"));
                break;

            case R.id.maps:
                intent = new Intent(intent.ACTION_VIEW, Uri.parse("geo:37.30,127.2?z=10"));
                break;

            case R.id.web:
                intent = new Intent(intent.ACTION_VIEW, Uri.parse("https://google.com"));
                break;

            case R.id.contacts:
                intent = new Intent(intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                break;
        }

        if(intent != null)
            startActivity(intent);
    }

}
