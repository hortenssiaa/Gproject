package com.example.survey;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    RadioGroup group;
    RadioButton rbutton1, rbutton2, rbutton3;
    Button button;
    ImageView imageView;

    View.OnClickListener radio_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (group.getCheckedRadioButtonId()){
                case R.id.radio1:
                    imageView.setImageResource(R.drawable.monster_smile233); //라디오버튼 radio1을 클릭하면, imageview가 monster_smile233으로 세팅된다.
                    break;
                case R.id.radio2:
                    imageView.setImageResource(R.drawable.monster_smile41);
                    break;
                case R.id.radio3:
                    imageView.setImageResource(R.drawable.monster_smile443);
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //앞에서 만든 뷰들하나씩 연결해주기
        group = (RadioGroup) findViewById(R.id.radiogroup);
        rbutton1 = (RadioButton) findViewById(R.id.radio1);
        rbutton2 = (RadioButton) findViewById(R.id.radio2);
        rbutton3 = (RadioButton) findViewById(R.id.radio3);

        rbutton1.setOnClickListener(radio_listener); //setOnClickListener 만들어줬고, 버튼 하나하나에 설정을 해줘야 이벤트를 처리할 거 아니야
        rbutton2.setOnClickListener(radio_listener);
        rbutton3.setOnClickListener(radio_listener);

        imageView = (ImageView) findViewById(R.id.image1);
        button = (Button) findViewById(R.id.imageButton);
    }
}
