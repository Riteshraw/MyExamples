package com.example.admin.myexamples.Broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by admin on 7/19/2016.
 */
public class TestReveiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        if(intent.getAction().contains("Manual_start")){
//            context.startService(new Intent(context, TestService.class));
//        }
        if (intent.getAction().equals("Manual_start"))
            Toast.makeText(context, "this is a test", Toast.LENGTH_SHORT).show();

    }
}
