package com.example.widgetexamples_ch6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

class Myview extends View {
    int x=0, y=0;

    public Myview(Context context){
        super(context);
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = (int) event.getX();
        y = (int) event.getY();
        invalidate(); // 화면을 다시 그리고 싶다는 요청 // 계속 계속 update 돼야 하니깐
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setTextSize(60);
        canvas.drawText("("+x+", "+y+")에서 터치 이벤트가 발생하였음", x, y, paint);
    }
}

public class MyViewEvent extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Myview myview = new Myview(this);
        setContentView(myview);
    }
}


