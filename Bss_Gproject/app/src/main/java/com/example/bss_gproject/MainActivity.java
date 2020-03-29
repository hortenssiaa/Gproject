package com.example.bss_gproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    /*
    MapView mapView = new MapView(this);
    ct_map.addView(mapView);
     */
/*
    try {
        PackageInfo info = getPackageManager().getPackageInfo("com.yjw.android.busanbus",
                PackageManager.GET_SIGNATURES);
        for (Signature signature : info.signatures) {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(signature.toByteArray());
            String str = Base64.encodeToS tring(md.digest(), Base64.DEFAULT);
            Log.d("KeyHash:", str);
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        }
    } catch(NoSuchAlgorithmException e){
        e.printStackTrace();
    } catch(PackageManager.NameNotFoundException e){
        e.printStackTrace();
    }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
