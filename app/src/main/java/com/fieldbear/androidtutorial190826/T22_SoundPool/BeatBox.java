package com.fieldbear.androidtutorial190826.T22_SoundPool;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {
    private AssetManager mAssetManager;
    private List<Sound> mSounds = new ArrayList<>();

    public BeatBox(Context context){
        mAssetManager = context.getAssets();
        loadSounds();
    }

    public List<Sound> getSounds() {
        return mSounds;
    }

    private void loadSounds(){
        String[] soundNames;
        try {
            soundNames = mAssetManager.list("sample_sound");
            Log.i("BeatBox", "found : "+soundNames.length);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        for(String fileName: soundNames){
            String assetPath = "sample_sound/"+fileName;
            Sound sound = new Sound(assetPath);
            mSounds.add(sound);
        }
    }
}
