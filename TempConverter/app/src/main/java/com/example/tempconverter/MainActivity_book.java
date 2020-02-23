package com.example.tempconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_book extends AppCompatActivity {
    private EditText editText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.edittext);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.converter_button: //변환버튼
                RadioButton rbuttonC = (RadioButton) findViewById(R.id.radio1);
                RadioButton rbuttonF = (RadioButton) findViewById(R.id.radio2);

                //if there's nothing in editText
                if(editText.getText().length() == 0){
                    Toast.makeText(this, "정확한 값을 입력하시오.", Toast.LENGTH_SHORT).show();
                    return;
                }

                float temperature = Float.parseFloat(editText.getText().toString());

                //if there's something in editText
                if(rbuttonC.isChecked()){
                    editText.setText(String.valueOf(CelsiusToFahrenheit(temperature)));
                    //rbuttonC.setChecked(false);
                } else if (rbuttonF.isChecked()) {
                    editText.setText(String.valueOf(FahrenheitToCelsius(temperature)));
                    //rbuttonF.setChecked(false);
                }
                break;
            }
    }
    //make method of CtoF
    private float CelsiusToFahrenheit(float celsius){
        return (celsius-32)/(9/5);
    }

    //make method of FtoC
    private float FahrenheitToCelsius(float fahrenheit){
        return (32 + (fahrenheit * 9/5));
    }
}
