package com.example.bss_gproject.gproject.activities;

import android.os.Bundle;
import android.view.ViewGroup;

import com.example.bss_gproject.R;

import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapview);

        MapView mapView = new MapView(this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        mapView.setMapViewEventListener((MapView.MapViewEventListener) this); // this에 MapView.MapViewEventListener 구현.
        mapView.setPOIItemEventListener((MapView.POIItemEventListener) this);

        // 중심점 변경
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.53737528, 127.00557633), true);
        // 줌 레벨 변경
        mapView.setZoomLevel(7, true);
        // 중심점 변경 + 줌 레벨 변경
        mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(33.41, 126.52), 9, true);
        // 줌 인
        mapView.zoomIn(true);
        // 줌 아웃
        mapView.zoomOut(true);
    }
}

