package com.fieldbear.androidtutorial190826.T04_customListView;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.fieldbear.androidtutorial190826.R;

import java.util.ArrayList;

public class T05_CustomListViewActivity extends AppCompatActivity {

    class Weather{
        String cityName;
        String weatherText;
        int temperature;
        int imgRes;
    }

    ArrayList<Weather> list = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t05__custom_list_view);
    }
}
