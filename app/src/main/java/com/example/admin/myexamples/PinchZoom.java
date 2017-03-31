package com.example.admin.myexamples;

import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

import com.example.admin.myexamples.Fragment.DialogImageFragment;

public class PinchZoom extends AppCompatActivity {
    private ImageView imageView;
    private ScaleGestureDetector scaleGestureDetector;
    private Matrix matrix = new Matrix();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinch_zoom);
/*        imageView = (ImageView)findViewById(R.id.img);
        imageView.setRotation(90);*/

/*        ZoomableImageView touch = (ZoomableImageView)findViewById(R.id.img_zoom);
        touch.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.colerd_thank_you));

        touch.setRotation(90);*/

        DialogImageFragment dialog = new DialogImageFragment();
        dialog.show(getFragmentManager(), "MyDialogFragment");

//        scaleGestureDetector = new ScaleGestureDetector(this,new ScaleListener());
    }

  /*  @Override
    public boolean onTouchEvent(MotionEvent ev) {
        scaleGestureDetector.onTouchEvent(ev);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.
            SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            float scaleFactor = detector.getScaleFactor();
            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 5.0f));
            matrix.setScale(scaleFactor, scaleFactor);
            imageView.setImageMatrix(matrix);


            return true;
        }
    }*/
}