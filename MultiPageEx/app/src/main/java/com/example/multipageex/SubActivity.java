package com.example.multipageex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        editText = (EditText) findViewById(R.id.edittext1);
        Button button_ok = (Button) findViewById(R.id.b_ok);
        Button button_canceled = (Button) findViewById(R.id.b_canceled);

        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("INPUT_TEXT", editText.getText().toString()); //저장(put)할 데이터를 edittext에서 받으므로, 받을 데이터는 문자열이다. 따라서 String
                setResult(RESULT_OK, intent); //(int Result_code, Intent data)
                finish(); //mainActivity의 onActivityResult함수로 결과값을 보낸다.
            }
        });

        button_canceled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
