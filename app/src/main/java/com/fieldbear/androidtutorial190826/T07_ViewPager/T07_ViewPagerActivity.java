package com.fieldbear.androidtutorial190826.T07_ViewPager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.fieldbear.androidtutorial190826.R;


public class T07_ViewPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        ViewPager pager = findViewById(R.id.pager);
        MyPagerAdapter adapter = new MyPagerAdapter( getSupportFragmentManager());
        pager.setAdapter(adapter);
    }


}
