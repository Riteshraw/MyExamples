package com.example.admin.myexamples;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Thread_tutorial extends AppCompatActivity {
    Handler mHandler = new Handler();
    private Runnable runable;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_tutorial);

        Button btn_thread = (Button) findViewById(R.id.btn_thread);
        btn_thread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startService(new Intent(Thread_tutorial.this, TestService.class));
            }
        });

//        thread_handler();
        handler_delay();
//        infinite_handler();

    }

    private void infinite_handler() {
        runable = new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Thread_tutorial.this, "hello handler", Toast.LENGTH_SHORT).show();
                mHandler.postDelayed(runable, 4000);
            }
        };
        mHandler.postDelayed(runable, 4000);
    }

    private void handler_delay() {
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Thread_tutorial.this, "hello handler", Toast.LENGTH_SHORT).show();
            }

        }, 5000);
    }

    private void thread_handler() {
        try {
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
//                    Toast.makeText(Thread_tutorial.this, "hello handler", Toast.LENGTH_SHORT).show();
                    Log.d("tag","thread");
                }
            });
            thread.start();
        } catch (Exception e) {
        }
    }

}
