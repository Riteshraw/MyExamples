package com.example.admin.myexamples;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ArrowTabHost extends AppCompatActivity {
    TextView txt1, txt2, txt3, txt4;
    private Button btn_next;
    private SharedPreferences sharedPreferences;
    int click=1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrow_tab_host);
        initialiseControls();

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                switch (click) {
                    case 0:
                        txt1.setBackgroundResource(R.drawable.tri);
                        txt2.setBackgroundResource(R.drawable.red);
                        txt3.setBackgroundResource(R.drawable.red);
                        txt4.setBackgroundResource(R.drawable.red);
                        break;

                    case 1:
                        txt1.setBackgroundResource(R.drawable.red);
                        txt2.setBackgroundResource(R.drawable.tri);
                        txt3.setBackgroundResource(R.drawable.red);
                        txt4.setBackgroundResource(R.drawable.red);
                        break;

                    case 2:
                        txt1.setBackgroundResource(R.drawable.red);
                        txt2.setBackgroundResource(R.drawable.red);
                        txt3.setBackgroundResource(R.drawable.tri);
                        txt4.setBackgroundResource(R.drawable.red);
                        break;

                    case 3:
                        txt1.setBackgroundResource(R.drawable.red);
                        txt2.setBackgroundResource(R.drawable.red);
                        txt3.setBackgroundResource(R.drawable.red);
                        txt4.setBackgroundResource(R.drawable.tri);
                        break;
                }
                click++;
                if (click == 4)
                    click = 0;

            }
        });
    }

    private void initialiseControls() {
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt4 = (TextView) findViewById(R.id.txt4);
        btn_next = (Button) findViewById(R.id.btn_next);

//        sharedPreferences = getSharedPreferences("Tab",MODE_PRIVATE);


        txt1.setBackgroundResource(R.drawable.tri);
        txt2.setBackgroundResource(R.drawable.red);
        txt3.setBackgroundResource(R.drawable.red);
        txt4.setBackgroundResource(R.drawable.red);
    }
}
