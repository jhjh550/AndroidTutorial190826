package com.fieldbear.androidtutorial190826.T02_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fieldbear.androidtutorial190826.R;

public class T02_New_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t02__new_);

        Intent intent = getIntent();
        int myValue = intent.getIntExtra("myValue", 0);

        Toast.makeText(this, "value : "+myValue,
                Toast.LENGTH_LONG).show();

        Button btnFinish = findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("myResult", 200);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
