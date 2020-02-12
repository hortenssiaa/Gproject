package com.example.widgetexamples_ch6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class TouchEventActivity extends AppCompatActivity {

    protected class MyView extends View {
        private int x=0, y=0;
        String str;

        public MyView(Context context){
            super(context);
            setBackgroundColor(Color.YELLOW);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            Paint paint = new Paint();
            paint.setTextSize(45);
            paint.setColor(Color.MAGENTA);
            canvas.drawText("액션의 종류: "+ str, 10, 100, paint);
            canvas.drawRect(x,y, x+100, y+100, paint);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            x = (int) event.getX();
            y = (int) event.getY();

            if (event.getAction() == MotionEvent.ACTION_DOWN)
                str = "ACTION_DOWN";
            if (event.getAction() == MotionEvent.ACTION_UP)
                str = "ACTION_UP";
            if (event.getAction() == MotionEvent.ACTION_MOVE)
                str = "ACTION_MOVE";

            invalidate();
            return true;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyView myView = new MyView(this);
        setContentView(myView);
    }
}
