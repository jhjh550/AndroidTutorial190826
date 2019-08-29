package com.fieldbear.androidtutorial190826.T22_SoundPool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.fieldbear.androidtutorial190826.R;

public class T22_SoundPoolActivity extends AppCompatActivity {

    private BeatBox mBeatBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t22__sound_pool);

        mBeatBox = new BeatBox(this);

        RecyclerView beatBoxRecyclerView = findViewById(R.id.beatBoxRecyclerView);
        beatBoxRecyclerView.setLayoutManager(
                new GridLayoutManager(this, 3));
        beatBoxRecyclerView.setAdapter(new SoundAdapter(mBeatBox.getSounds()));
    }
}
