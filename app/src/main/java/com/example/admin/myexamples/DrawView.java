package com.example.admin.myexamples;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View {
    Paint paint = new Paint();
    float startX, startY, stopX, stopY;

    public DrawView(Context context) {
        super(context);
        paint.setColor(Color.BLACK);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawLine(startX, startY, stopX, stopY, paint);
//        canvas.drawLine(20, 0, 0, 20, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startTouch(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                moveTouch(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
//                upTouch();
//                invalidate();
                break;
        }
        return true;
    }

    private void moveTouch(float x, float y) {
        stopX = x;
        stopY = y;
    }

    private void startTouch(float x, float y) {
        startX = x;
        startY = y;
    }

}
