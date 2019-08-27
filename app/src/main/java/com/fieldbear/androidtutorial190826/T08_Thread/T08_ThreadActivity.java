package com.fieldbear.androidtutorial190826.T08_Thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fieldbear.androidtutorial190826.R;

public class T08_ThreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t08__thread);

        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0; i<100000; i++){
                            Log.d("MyThread", "count : "+i);
                        }
                    }
                }).start();

                Toast.makeText(T08_ThreadActivity.this,
                        "count done!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
