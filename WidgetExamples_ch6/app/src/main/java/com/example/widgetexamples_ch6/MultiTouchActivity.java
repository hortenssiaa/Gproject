package com.example.widgetexamples_ch6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MultiTouchActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MultiTouchView(this, null));
    }
}

class MultiTouchView extends View{
    private static final int radius = 60;

    final int MaxTouch = 10;
    private float x[] = new float[MaxTouch];
    private float y[] = new float[MaxTouch];
    boolean[] touching = new boolean[MaxTouch];

    public MultiTouchView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int index = event.getActionIndex();
        int id = event.getPointerId(index); //인덱스의(인덱스에 따른) 아이디를 갖고오는 것
        int action = event.getActionMasked();
        /*
        x, y에 대한 id 결정은 (즉 0,1,2,3 ... 0,1 되는 거는 컴터에서 알아서 되는듯
         */

        switch (action){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                x[id] = event.getX(index);
                y[id] = event.getY(index);
                touching[id] = true; //touching을 true / false로 판단하는 이유는 onTouchEvent가 boolean 타입이기도 하고, true여야지 이 함수가 실행되고, 그 의미는 현재 터치가 되었다는 말이니깐 .
                break;

            case MotionEvent.ACTION_MOVE:
                break; //Move에서 바로 break하는 이유는, 이미 터치된(down) 상태가(true가) 유지되기 때문에

            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL:
                touching[id] = false;
                break;
        }

        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        for(int i=0; i<MaxTouch; i++){
            if (touching[i])
                canvas.drawCircle(x[i], y[i], radius, paint);
        }
    }
}
