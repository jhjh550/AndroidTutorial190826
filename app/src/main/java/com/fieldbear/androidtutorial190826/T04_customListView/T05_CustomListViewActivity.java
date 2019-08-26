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

        public Weather(String cityName, String weatherText, int temperature, int imgRes) {
            this.cityName = cityName;
            this.weatherText = weatherText;
            this.temperature = temperature;
            this.imgRes = imgRes;
        }
    }

    ArrayList<Weather> list = new ArrayList();

    private void initData(){
        list.add(new Weather("Berlin", "snowing",0, R.drawable.ic_snow));
        list.add(new Weather("Bangalore", "Thunderstorms",23, R.drawable.ic_thunder));
        list.add(new Weather("London", "rainy",5, R.drawable.ic_rainy));
        list.add(new Weather("New York", "cloudy",18, R.drawable.ic_cloud_black_24dp));
        list.add(new Weather("Sydney", "sunny",32, R.drawable.ic_wb_sunny_black_24dp));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t05__custom_list_view);

        initData();
    }
}
