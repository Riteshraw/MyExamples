package com.example.admin.myexamples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class TestZoom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_zoom);
        WebView webView = (WebView) findViewById(R.id.imageView);

        webView.loadDataWithBaseURL("file:///android_res/mipmap/", "<img src='colerd_thank_you.jpg' />", "text/html", "utf-8", null);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);

//        final Animation zoomAnimation = AnimationUtils.loadAnimation(this, R.anim.zoom);
//        zoom.startAnimation(zoomAnimation);
    }
}

