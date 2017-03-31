package com.example.admin.myexamples.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.widget.Toast;

import com.example.admin.myexamples.AlertActivity;

/**
 * Created by admin on 11/3/2016.
 */
public class GpsLocationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().matches("android.location.PROVIDERS_CHANGED")) {
//            Toast.makeText(context, "in android.location.PROVIDERS_CHANGED",Toast.LENGTH_SHORT).show();

            if (!((LocationManager) context.getSystemService(context.LOCATION_SERVICE)).isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                Toast.makeText(context, "GPS is OFF",Toast.LENGTH_SHORT).show();
                Intent pushIntent = new Intent(context, AlertActivity.class);
                pushIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(pushIntent);
            }

        }
    }
}