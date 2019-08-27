package com.fieldbear.androidtutorial190826.T09_AsyncTask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fieldbear.androidtutorial190826.R;

public class T09_AsyncTaskActivity extends AppCompatActivity {

    Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t09__async_task);

        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyTask().execute();
            }
        });
    }

    class MyTask extends AsyncTask<Void, Integer, String>{
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            btnStart.setText(""+values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            btnStart.setText(s);
        }

        @Override
        protected String doInBackground(Void... voids) {
            for(int i=0; i<100; i++){
                try {
                    Thread.sleep(100);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "done!";
        }
    }
}
