package com.fieldbear.androidtutorial190826.T14_Service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fieldbear.androidtutorial190826.R;

public class T14_Service_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t14__service_);

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
}
