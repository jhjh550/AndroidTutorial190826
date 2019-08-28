package com.fieldbear.androidtutorial190826.T14_Service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fieldbear.androidtutorial190826.R;

public class T14_Service_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t14__service_);

        Button btnRandomNumber = findViewById(R.id.btnRandomNumber);
        btnRandomNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mMyBoundService != null) {
                    int num = mMyBoundService.getRandomNumber();
                    Toast.makeText(T14_Service_Activity.this,
                            "random: " + num, Toast.LENGTH_LONG).show();
                }
            }
        });

        Button btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        T14_Service_Activity.this,
                        MyService.class);
                startService(intent);

//                MyIntentService.startActionFoo(
//                        T14_Service_Activity.this,
//                        "hello",
//                        "world"
//                );
            }
        });

        Button btnStop = findViewById(R.id.btnStop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        T14_Service_Activity.this,
                        MyService.class);
                stopService(intent);
            }
        });
    }

    MyBoundService mMyBoundService;
    ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyBoundService.MyBinder binder = (MyBoundService.MyBinder) service;
            mMyBoundService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mMyBoundService = null;
        }
    };


    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = new Intent(this, MyBoundService.class);
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(conn);
    }
}
