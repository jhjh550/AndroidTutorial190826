package com.fieldbear.androidtutorial190826.T05_SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fieldbear.androidtutorial190826.R;

public class T05_SharedPreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t05__shared_prefenences);

        Button btnShortCut = findViewById(R.id.btnShortCut);
        btnShortCut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        T05_SharedPreferencesActivity.this,
                        T05_AppListActivity.class);
                startActivity(intent);
            }
        });
    }
}
