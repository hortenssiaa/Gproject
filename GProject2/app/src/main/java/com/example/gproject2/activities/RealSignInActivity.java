package com.example.gproject2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gproject2.R;

import androidx.appcompat.app.AppCompatActivity;

public class RealSignInActivity extends AppCompatActivity {
    Button fbsi_button;
    Button kakosi_button;
    Button naversi_button;
    Button emailsi_button;
    Button signup_buttion;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_signin);

        fbsi_button = (Button) findViewById(R.id.fb_signinb);
        kakosi_button = (Button) findViewById(R.id.kakao_signinb);
        naversi_button = (Button) findViewById(R.id.naver_signinb);
        emailsi_button = (Button) findViewById(R.id.email_signinb);
        signup_buttion = (Button) findViewById(R.id.goto_signupb);

        fbsi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RealSignInActivity.this, Fragment_fbSignIn.class);
                startActivity(intent); //해야되나??
            }
        });

        kakosi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RealSignInActivity.this, Fragment_kakaoSignIn.class);
                startActivity(intent);
            }
        });

        naversi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RealSignInActivity.this, Fragment_naverSignIn.class);
                startActivity(intent);
            }
        });

        emailsi_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RealSignInActivity.this, Fragment_emailSignIn.class);
                startActivity(intent);
            }
        });

        signup_buttion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RealSignInActivity.this, SignUpFragment.class); //회원가입으로 다시
                startActivity(intent);
            }
        });

    }
}
//실제 각각 로그인 페이지로 연동되는 코드
// 아마 MainActivity 에서 onActivityResult 함수 작성하고 로그인 값? 받아와야겠지?