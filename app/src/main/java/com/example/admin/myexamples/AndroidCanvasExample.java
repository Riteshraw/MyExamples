package com.example.admin.myexamples;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.admin.myexamples.Broadcast.GpsLocationReceiver;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AndroidCanvasExample extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks {
    private CanvasView customCanvas;
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private GoogleApiClient googleApiClient;
    final static int REQUEST_LOCATION = 199;
    private BroadcastReceiver GPSreceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_canvas_example);
/*        GPSTracker gps = new GPSTracker(this);
        gps.showSettingsAlert();*/

        customCanvas = (CanvasView) findViewById(R.id.signature_canvas);
    }

    public void onResume()
    {
        super.onResume();
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.location.PROVIDERS_CHANGED");

        GPSreceiver = new GpsLocationReceiver();
        registerReceiver(GPSreceiver, filter);

    }

    public void onPause()
    {
        super.onPause();
        unregisterReceiver(GPSreceiver);
    }

    public void clearCanvas(View v) {
        customCanvas.clearCanvas();
    }

    public void saveCanvas(View v) {
//        customCanvas.saveCanvas();
        File folder = new File(Environment.getExternalStorageDirectory().toString());
        boolean success = false;
        if (!folder.exists()) {
            success = folder.mkdirs();
        }

        System.out.println(success + "folder");

        File file = new File(Environment.getExternalStorageDirectory().toString() + "/sample.png");

        if (!file.exists()) {
            try {
                success = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(success + "file");


        FileOutputStream ostream = null;
        try {
            ostream = new FileOutputStream(file);

            System.out.println(ostream);
            View targetView = customCanvas;

            // myDrawView.setDrawingCacheEnabled(true);
            //   Bitmap save = Bitmap.createBitmap(myDrawView.getDrawingCache());
            //   myDrawView.setDrawingCacheEnabled(false);
            // copy this bitmap otherwise distroying the cache will destroy
            // the bitmap for the referencing drawable and you'll not
            // get the captured view
            //   Bitmap save = b1.copy(Bitmap.Config.ARGB_8888, false);
            //BitmapDrawable d = new BitmapDrawable(b);
            //canvasView.setBackgroundDrawable(d);
            //   myDrawView.destroyDrawingCache();
            // Bitmap save = myDrawView.getBitmapFromMemCache("0");
            // myDrawView.setDrawingCacheEnabled(true);
            //Bitmap save = myDrawView.getDrawingCache(false);
            Bitmap well = customCanvas.getBitmap();
            Bitmap save = Bitmap.createBitmap(320, 480, Config.ARGB_8888);
            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            Canvas now = new Canvas(save);
            now.drawRect(new Rect(0, 0, 320, 480), paint);
            now.drawBitmap(well, new Rect(0, 0, well.getWidth(), well.getHeight()), new Rect(0, 0, 320, 480), null);

            // Canvas now = new Canvas(save);
            //myDrawView.layout(0, 0, 100, 100);
            //myDrawView.draw(now);
            if (save == null) {
                System.out.println("NULL bitmap save\n");
            }
            save.compress(Bitmap.CompressFormat.PNG, 100, ostream);
            //bitmap.compress(Bitmap.CompressFormat.PNG, 100, ostream);
            //ostream.flush();
            //ostream.close();
        } catch (NullPointerException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Null error", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "File error", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "IO error", Toast.LENGTH_SHORT).show();
        }

    }

    private void enableLoc() {

        if (googleApiClient == null) {
            googleApiClient = new GoogleApiClient.Builder(this)
                    .addApi(LocationServices.API)
                    .addConnectionCallbacks(AndroidCanvasExample.this)
                    .addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
                        @Override
                        public void onConnectionFailed(ConnectionResult connectionResult) {
                        }
                    }).build();
            googleApiClient.connect();

            LocationRequest locationRequest = LocationRequest.create();
            locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
            locationRequest.setInterval(30 * 1000);
            locationRequest.setFastestInterval(5 * 1000);
            LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);

            builder.setAlwaysShow(true);

            PendingResult<LocationSettingsResult> result = LocationServices.SettingsApi.checkLocationSettings(googleApiClient, builder.build());
            result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
                @Override
                public void onResult(LocationSettingsResult result) {
                    final Status status = result.getStatus();
                    switch (status.getStatusCode()) {
                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                            try {
                                // Show the dialog by calling startResolutionForResult(),
                                // and check the result in onActivityResult().
                                status.startResolutionForResult(AndroidCanvasExample.this, REQUEST_LOCATION);
                            } catch (IntentSender.SendIntentException e) {
                                // Ignore the error.
                            }
                            break;
                        case LocationSettingsStatusCodes.SUCCESS:
                            //this is for pop up for gps ,next line only
//                            onGPSSuccess();
                    }
                }
            });
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case REQUEST_LOCATION:
                switch (resultCode) {
                    case Activity.RESULT_CANCELED: {
                        // The user was asked to change settings, but chose not to
                        finish();
                        break;
                    }
                    case RESULT_OK:
//                        onGPSSuccess();
//                        loadFragment(new MapFragment(), false);
//                        Intent startApp = new Intent(SplashScreen.this, MainActivity.class);
//                        startActivity(startApp);
                    default: {
                        break;
                    }
                }
                break;
        }

    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }
}
