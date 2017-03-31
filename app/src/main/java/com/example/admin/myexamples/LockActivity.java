package com.example.admin.myexamples;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.admin.myexamples.Adapter.ImageAdapter;

public class LockActivity extends AppCompatActivity {
    private LinearLayout linearLayout;
    private ImageView imageView;
    private Paint paint = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
    }
}
