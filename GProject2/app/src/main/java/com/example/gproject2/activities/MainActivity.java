package com.example.gproject2.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gproject2.R;
import com.example.gproject2.interfaces.FragmentCallback;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentCallback {

    SignInFragment signInFragment;
    Fragment_fbSignIn fg_fbSignIn;
    Fragment_emailSignIn fg_emailSignIn;
    Fragment_kakaoSignIn fg_kakaoSignIn;
    Fragment_naverSignIn fg_naverSignIn;

    SignUpFragment signUpFragment;
    Fragment_fbSignUp fg_fbSignUp;
    Fragment_emailSignUp fg_emailSignUp;
    Fragment_kakaoSignUp fg_kakaoSignUp;
    Fragment_naverSignUp fg_naverSignUp;

    MapActivity mapActivity;
    Fragment1 fragment1;
    Fragment2_1 fragment2_1;
    Fragment2_2 fragment2_2;
    Fragment2_3 fragment2_3;
    Fragment2_4 fragment2_4;
    Fragment2_5 fragment2_5;
    Fragment3 fragment3;
    Fragment4 fragment4;

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBar actionBar;
    //View headerView;
    ImageButton imageButton_singin;
    TextView textView_singin;
    TextView textView_singin_sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTheme(android.R.style.Theme_NoTitleBar_Fullscreen);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //바로가기 목록 버튼
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        // Set the drawer toggle as the DrawerListener
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //headerView = navigationView.inflateHeaderView(R.layout.nav_header_main);
        //headerView = navigationView.getHeaderView(0);

        //header부분 image button, text view, text view suv 연결유무 확인 & 연결부분
        imageButton_singin = (ImageButton) navigationView.getHeaderView(0).findViewById(R.id.signin_imageButton);
        imageButton_singin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"working",Toast.LENGTH_LONG).show();
                onFragmentChanged(1);
                //signInFragment = new SignInFragment();
                //FragmentManager manager = getSupportFragmentManager();
                //signInFragment = (SignInFragment) manager.findFragmentById(R.id.signFragment);

                //signInFragment = (SignInFragment) getSupportFragmentManager().findFragmentById(R.id.nav_header_main);
            }
        });

        textView_singin = (TextView) navigationView.findViewById(R.id.signin_Textview);
        textView_singin_sub = (TextView) navigationView.findViewById(R.id.signin_TextviewSub);

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);//기본 제목을 없애줍니다.
        actionBar.setDisplayHomeAsUpEnabled(true);

        signInFragment = new SignInFragment();
        fg_fbSignIn = new Fragment_fbSignIn();
        fg_emailSignIn = new Fragment_emailSignIn();
        fg_kakaoSignIn = new Fragment_kakaoSignIn();
        fg_naverSignIn = new Fragment_naverSignIn();

        signUpFragment = new SignUpFragment();
        fg_fbSignUp = new Fragment_fbSignUp();
        fg_emailSignUp = new Fragment_emailSignUp();
        fg_naverSignUp = new Fragment_naverSignUp();
        fg_kakaoSignUp = new Fragment_kakaoSignUp();

        mapActivity = new MapActivity();
        fragment1 = new Fragment1();
        fragment2_1 = new Fragment2_1();
        fragment2_2 = new Fragment2_2();
        fragment2_3 = new Fragment2_3();
        fragment2_4 = new Fragment2_4();
        fragment2_5 = new Fragment2_5();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();

        getSupportFragmentManager().beginTransaction().add(R.id.container, mapActivity).commit();
        //Main화면인, R.id.container부분에(activity_main.xml에 있음) mapActivity xml 화면 보여줌

    }

    public void signinBt_onClick(View view){
        switch (view.getId()) {
            case R.id.fb_signinb:
                onFragmentChanged(2);
                break;

            case R.id.kakao_signinb:
                onFragmentChanged(3);
                break;

            case R.id.naver_signinb:
                onFragmentChanged(4);
                break;

            case R.id.email_signinb:
                onFragmentChanged(5);
                break;

            case R.id.goto_signupb:
                onFragmentChanged(6);
                break;
            }
    }

    public void signupBt_onClick(View view) {
        switch (view.getId()) {
            case R.id.fb_signupb:
                onFragmentChanged(7);
                break;

            case R.id.kakao_signupb:
                onFragmentChanged(8);
                break;

            case R.id.naver_signupb:
                onFragmentChanged(9);
                break;

            case R.id.email_signupb:
                onFragmentChanged(10);
                break;
        }
    }

    public void headerTVonClick(View view){ //Sign in 해주세요 Text view 부분 onClick
        switch (view.getId()) {
            case R.id.signin_Textview:
                Toast.makeText(getApplicationContext(),"Signin_Textview_working",Toast.LENGTH_LONG).show();
                onFragmentChanged(1);
                break;

            case R.id.signin_TextviewSub:
                Toast.makeText(getApplicationContext(),"Signin_Textview_Sub_working",Toast.LENGTH_LONG).show();
                onFragmentChanged(1);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();

        //nav_2, My 플레이스 클릭시 아무 반응 없게 하는것 - 지금 상태 괜찮나?
        if (id == R.id.nav_home) { //메인 지도
            onFragmentSelected(8, null);
        } else if (id == R.id.nav_1) { // 길찾기
            onFragmentSelected(0, null);
        } else if (id == R.id.nav_2_1) { // 전체보기 - My 플레이스(바로가기)
            onFragmentSelected(1, null);
        } else if (id == R.id.nav_2_2) { // 공원 - My 플레이스(바로가기)
            onFragmentSelected(2, null);
        } else if (id == R.id.nav_2_3) { // 산 - My 플레이스(바로가기)
            onFragmentSelected(3, null);
        } else if (id == R.id.nav_2_4) { // 강/탄천 - My 플레이스(바로가기)
            onFragmentSelected(4, null);
        } else if (id == R.id.nav_2_5) { // My 운동그룹 - My 플레이스(바로가기)
            onFragmentSelected(5, null);
        } else if (id == R.id.nav_3) { // 운동그룹
            onFragmentSelected(6, null);
        } else if (id == R.id.nav_4) { // 실시간 운동인증
            onFragmentSelected(7, null);
        }
        /*else if (id == R.id.signin_imageButton) { // signin button
            onFragmentSelected(8, null);
        } else if (id == R.id.signin_Textview) { // signin text view
            onFragmentSelected(9, null);
        } else if (id == R.id.signin_TextviewSub) { // signin text view sub
            onFragmentSelected(10, null);
        }

         */

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @SuppressLint("WrongViewCast")
    @Override
    public void onFragmentSelected(int position, Bundle bundle) {
        Fragment curFragment = null;

        if (position == 0) {
            curFragment = fragment1;
            toolbar.setTitle("길찾기");
            //requestWindowFeature(Window.FEATURE_NO_TITLE);
        } else if (position == 1) {
            curFragment = fragment2_1;
            toolbar.setTitle("전체보기");
        } else if (position == 2) {
            curFragment = fragment2_2;
            toolbar.setTitle("공원");
        } else if (position == 3) {
            curFragment = fragment2_3;
            toolbar.setTitle("산");
        } else if (position == 4) {
            curFragment = fragment2_4;
            toolbar.setTitle("강/탄천");
        } else if (position == 5) {
            curFragment = fragment2_5;
            toolbar.setTitle("My 운동그룹");
        } else if (position == 6) {
            curFragment = fragment3;
            toolbar.setTitle("운동그룹");
            // toolbar.setTitle((CharSequence) findViewById(R.id.fg3_titleText)); // 이 방식안됨 - 타이틀바에 + 밑에 이 textview로 한단이 더 추가돼서 나옴
        } else if (position == 7) {
            curFragment = fragment4;
            toolbar.setTitle("실시간 운동인증");
            // bold 설정하는 방법 추가했으면!
        } else if (position == 8) {
            curFragment = mapActivity;
            toolbar.setTitle(" ");
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.container, curFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu); //actionbar_menu에 search 검색기능 있음
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int curId = item.getItemId();
        switch (curId) {
            case R.id.menu_search:
        }
        return super.onOptionsItemSelected(item);
    }

    public void onFragmentChanged(int index) {
        toolbar.setTitle(" ");

        if (index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, mapActivity).commit();
        } else if (index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, signInFragment).commit();
        } else if (index == 2) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fg_fbSignIn).commit();
        } else if (index == 3) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fg_kakaoSignIn).commit();
        } else if (index == 4) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fg_naverSignIn).commit();
        } else if (index == 5) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fg_emailSignIn).commit();
        } else if (index == 6) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, signUpFragment).commit();
        } else if (index == 7) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fg_fbSignUp).commit();
        } else if (index == 8) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fg_kakaoSignUp).commit();
        } else if (index == 9) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fg_naverSignUp).commit();
        } else if (index == 10) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fg_emailSignUp).commit();
        }
    }
}
