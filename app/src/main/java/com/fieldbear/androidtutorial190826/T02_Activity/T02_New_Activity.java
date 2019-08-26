package com.fieldbear.androidtutorial190826.T02_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.fieldbear.androidtutorial190826.R;

public class T02_New_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t02__new_);

        Intent intent = getIntent();
        int myValue = intent.getIntExtra("myValue", 0);
    }
}
