package com.example.admin.myexamples;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class HttpActivity extends AppCompatActivity {
    String url = "hmkcode.com/examples/index.php";
    TextView txt1;
    private ProgressBar progressBar;
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);

        txt1 = (TextView) findViewById(R.id.txt1);
        TextView txt2 = (TextView) findViewById(R.id.txt2);
        ll = (LinearLayout) findViewById(R.id.activity_http);

        progressBar = new ProgressBar(getApplicationContext());

/*        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(40, 40);
        progressBar.setLayoutParams(params );*/

        new GetAsync().execute("http://hmkcode.com/examples/index.php");
    }

    private class GetAsync extends AsyncTask<String, Void, String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            ViewGroup vg = ((ViewGroup) HttpActivity.this.getWindow().getDecorView());
            vg.addView(progressBar);
        }

        @Override
        protected String doInBackground(String... params) {
            String data = "";
            InputStream is = null;
            int len = 500;

            try {
                URL url = new URL(params[0]);
                URLConnection urlcon = url.openConnection();
                InputStream stream = urlcon.getInputStream();
                int i;
                while ((i = stream.read()) != -1) {
                    data = data + ((char) i);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
//            progressBar.setVisibility(View.INVISIBLE);
            txt1.setText(result);
        }
    }
}
