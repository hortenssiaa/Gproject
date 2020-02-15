package com.example.tempconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    double centigrade = 0;
    double fahrenheit = 0;
    double temp;
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2;
    Button button;
    EditText editText;

    View.OnClickListener radio_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            editText = (EditText) findViewById(R.id.edittext);
            temp = Double.parseDouble(editText.getText().toString());

            switch (radioGroup.getCheckedRadioButtonId()){
                case R.id.radio1: //centigrade 섭씨로 받은 temp -> F
                    fahrenheit = 32 + (temp * 1.8);
                    editText.setText(fahrenheit+"");
                    break;
                case R.id.radio2: //Fahrenheit 화씨로 받은 temp -> C
                    centigrade = (temp-32)/1.8;
                    editText.setText(centigrade+"");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.group);
        radioButton1 = (RadioButton) findViewById(R.id.radio1);
        radioButton2 = (RadioButton) findViewById(R.id.radio2);
        button = (Button) findViewById(R.id.converter_button);

        button.setOnClickListener(radio_listener);
    }
}
