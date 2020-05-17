package com.example.gproject2.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gproject2.R;

import androidx.fragment.app.Fragment;

public class SignInFragment extends Fragment { //로그인 화면 연결

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_signin, container, false);
    }


/*
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_signin, container, false);
        // nav_header_main.xml 레이아웃을 가져와서 설정 & 기능하게 해주는 코드!
        // inflate() 메서드로 전달되는 첫 번째 파라미터 - XML레이아웃 파일 즉, R,layout.fragment_signin
        // 두 번째 파라미터 - 이 XML 레이아웃이 설정 될 뷰그룹 객체가 되는데, onCreateView() 메서드로 전달되는 두 번째 파라미터가 이 프레그먼트의 가장 상위 레이아웃!
        // 따라서, container 객체를 전달하면 된다.
        // inflate() 메서드를 호출하면 인플레이션이 진행되고 그 결과로 ViewGroup 객체가 반환됩니다. 이 객체를 return 키워드를 사용하여 반환!!

        return rootView;
        */


    // onActivityCreated는
    // 액티비티에서 프래그먼트를 모두 생성하고 난 다음 호출된다.
    // 액티비티의 onCreate()에서 setContentView()한 다음과 유사하다. 이후에 UI 변경 작업이 가능하다.
    /*
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }*/
}
