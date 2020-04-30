package com.example.gproject2.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTheme(android.R.style.Theme_NoTitleBar_Fullscreen);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);//기본 제목을 없애줍니다.
        actionBar.setDisplayHomeAsUpEnabled(true);


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

        if (id == R.id.nav_1) { // 길찾기
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

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @SuppressLint("WrongViewCast")
    @Override
    public void onFragmentSelected(int position, Bundle bundle) {
        Fragment curFragment = null;
        ActionBar actionBar;

        if (position == 0) {
            curFragment = fragment1;
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        } else if (position == 1) {
            curFragment = fragment2_1;
            toolbar.setTitle((CharSequence) findViewById(R.id.fg2_1_titleText));


            toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            drawerLayout = findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawerLayout.addDrawerListener(toggle);

            toggle.syncState();
            actionBar = getSupportActionBar();
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);//기본 제목을 없애줍니다.
            actionBar.setDisplayHomeAsUpEnabled(true);
        } else if (position == 2) {
            curFragment = fragment2_2;
            toolbar.setTitle((CharSequence) findViewById(R.id.fg2_2_titleText));
        } else if (position == 3) {
            curFragment = fragment2_3;
            toolbar.setTitle((CharSequence) findViewById(R.id.fg2_3_titleText));
        } else if (position == 4) {
            curFragment = fragment2_4;
            toolbar.setTitle((CharSequence) findViewById(R.id.fg2_4_titleText));
        } else if (position == 5) {
            curFragment = fragment2_5;
            toolbar.setTitle((CharSequence) findViewById(R.id.fg2_5_titleText));
        } else if (position == 6) {
            curFragment = fragment3;
            toolbar.setTitle((CharSequence) findViewById(R.id.fg3_titleText)); // 이 방식 안되면
        } else if (position == 4) {
            curFragment = fragment4;
            toolbar.setTitle("실시간 운동인증"); // 이 방식으로!!!!
            toolbar.setTitleTextColor(Integer.parseInt("#FFFFFFFF"));
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.container, curFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu, menu);
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
}
