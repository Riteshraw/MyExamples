package com.example.admin.myexamples.Service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import com.example.admin.myexamples.MainActivity;
import com.example.admin.myexamples.R;

/**
 * Created by admin on 7/19/2016.
 */
public class TestService extends Service {
    Handler mHandler = new Handler();
    private NotificationManager nManager;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        nManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(TestService.this)
                .setSmallIcon(R.mipmap.ic_launcher);

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (true) {
                    try {
                        Thread.sleep(5000);
                        mHandler.post(new Runnable() {

                            @Override
                            public void run() {
//                                Toast.makeText(TestService.this, "hello thread handler", Toast.LENGTH_SHORT).show();

                                builder.setContentTitle("Service")
                                        .setContentText("" + System.currentTimeMillis())
                                        .setAutoCancel(false);

                                nManager.notify(1, builder.build());
                            }
                        });
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                }
            }
        }).start();

        return startServiceForeground();
    }

    public int startServiceForeground() {

        Intent notificationIntent = new Intent(this, MainActivity.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("Location update Service")
                .setContentIntent(pendingIntent)
                .setOngoing(true)
                .build();

        startForeground(1, notification);

        return START_NOT_STICKY;
    }

}
