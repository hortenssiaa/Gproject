package com.example.widgetexamples_ch6;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class VolumControlview extends ImageView implements View.OnTouchListener{

    private KnobListener listener;
    private double angle =0.0;
    float x, y;
    float mx, my;

    public interface KnobListener{
        public void onChanged(double angle);
    }

    public void setKnobListener(KnobListener lis){
        listener=lis;
    }

    public VolumControlview(Context context){ //생성자는 왜만들지?
        super(context);
        this.setImageResource(R.drawable.knod);
        this.setOnTouchListener(this); //터치가 일어났을때, onTouchListener가 호출 됐을때, 이 클래스가 반응한다.
    }

    public VolumControlview(Context context, AttributeSet attrs){
        super(context, attrs);
        this.setImageResource(R.drawable.knod);
        this.setOnTouchListener(this);
    }

    private double getAngle(float x, float y){
        mx = x - (getWidth() / 2.0f);
        my = (getHeight() / 2.0f) - y;

        double degree = Math.atan2(mx, my) * 180.0 / 3.141592;

        return degree;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        x = motionEvent.getX(0);
        y = motionEvent.getY(0);
        angle = getAngle(x,y);
        invalidate();
        listener.onChanged(angle);

        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        canvas.save();
        canvas.rotate((float)angle, getWidth() / 2, getHeight() / 2);
        super.onDraw(canvas);
        canvas.restore();
    }
}
