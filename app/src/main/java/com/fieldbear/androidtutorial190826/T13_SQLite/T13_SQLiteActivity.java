package com.fieldbear.androidtutorial190826.T13_SQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.fieldbear.androidtutorial190826.R;

public class T13_SQLiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t13__sqlite);

        TestDBHelper helper = new TestDBHelper(this);
        helper.insert("kim", 11, "서울");
        helper.insert("lee", 22, "busan");
        helper.insert("park", 33, "인천");

        helper.update("kim", 13);
        String res = helper.selectAll();

        TextView textViewResult = findViewById(R.id.textViewResult);
        textViewResult.setText(res);

    }
}
