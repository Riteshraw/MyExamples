package com.example.admin.myexamples;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TestCanvas extends AppCompatActivity {
    private CanvasView customCanvas;
    DrawView drawView;
    DemoView demoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_canvas);
//        customCanvas = (CanvasView) findViewById(R.id.signature_canvas);

//        drawView = new DrawView(this);
//        drawView.setBackgroundColor(Color.WHITE);
//        setContentView(drawView);
        demoview = new DemoView(this);
        setContentView(demoview);

    }

    public class DemoView extends View {
        public DemoView(Context context){
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);

            paint.setColor(Color.WHITE);
            canvas.drawLine(10,10,50,50,paint);
            paint.setAntiAlias(false);

        }
    }
}