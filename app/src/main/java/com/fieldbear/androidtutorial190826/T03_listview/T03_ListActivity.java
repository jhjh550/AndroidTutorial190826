package com.fieldbear.androidtutorial190826.T03_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.fieldbear.androidtutorial190826.MainActivity;
import com.fieldbear.androidtutorial190826.R;

public class T03_ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t03__list);

        final String[] list = {"hello", "world", "123", "456",
                "hello", "world", "123", "456",
                "hello", "world", "123", "456",
                "hello", "world", "123", "456",
        };

        ListView myListView = findViewById(R.id.myListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                T03_ListActivity.this,
                android.R.layout.simple_list_item_1,
                list
        );
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = list[position];
                Toast.makeText(T03_ListActivity.this,
                        "pos: "+position+" item: "+item,
                        Toast.LENGTH_LONG).show();
            }
        });



    }
}
