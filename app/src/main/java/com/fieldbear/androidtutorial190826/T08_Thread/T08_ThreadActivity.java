package com.fieldbear.androidtutorial190826.T08_Thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fieldbear.androidtutorial190826.R;

public class T08_ThreadActivity extends AppCompatActivity {

    private static final int MY_COUNT = 100;
    Button btnStart;
    Handler myHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(msg.what == MY_COUNT) {
                btnStart.setText(msg.arg1+"");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t08__thread);

        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0; i<100; i++){
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            Log.d("MyThread", "count : "+i);
                            Message msg = myHandler.obtainMessage();
                            msg.what = MY_COUNT;
                            msg.arg1 = i;

                            myHandler.sendMessage(msg);
                        }
                    }
                }).start();

                Toast.makeText(T08_ThreadActivity.this,
                        "count done!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
