package com.fieldbear.androidtutorial190826.T21_RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.fieldbear.androidtutorial190826.R;

import java.util.ArrayList;

public class T21_RecyclerViewActivity extends AppCompatActivity {

    class MyRecyclerViewData{
        public MyRecyclerViewData(String title, String desc, int img, int temp) {
            this.title = title;
            this.desc = desc;
            this.img = img;
            this.temp = temp;
        }

        String title;
        String desc;
        int img;
        int temp;
    }

    ArrayList<MyRecyclerViewData> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t21__recycler_view);

        generateData();
        RecyclerView recyclerView = findViewById(R.id.myRecyclerView);
        MyRecyclerViewAdapter adapter =
                new MyRecyclerViewAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void generateData(){
        int[] temp = {R.drawable.ic_rainy, R.drawable.ic_cloud_black_24dp,
            R.drawable.ic_snow, R.drawable.ic_thunder,
            R.drawable.ic_wb_sunny_black_24dp};

        for(int i=0; i<100; i++){
            list.add(new MyRecyclerViewData("title "+i,
                    "desc"+i, temp[i%(temp.length)],i));
        }

    }
}
