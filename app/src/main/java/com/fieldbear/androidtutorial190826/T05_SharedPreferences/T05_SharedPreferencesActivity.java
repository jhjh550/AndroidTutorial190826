package com.fieldbear.androidtutorial190826.T05_SharedPreferences;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.fieldbear.androidtutorial190826.R;

public class T05_SharedPreferencesActivity extends AppCompatActivity {

    private static final int REQ_CODE = 100;
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t05__shared_prefenences);
        mImageView = findViewById(R.id.imageView);
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = mImageView.getDrawable();
                if(drawable != null){
                    SharedPreferences pref = PreferenceManager
                            .getDefaultSharedPreferences(T05_SharedPreferencesActivity.this);
                    String packageName = pref.getString("shortcut", null);
                    if(packageName != null){
                        Intent intent = getPackageManager()
                                .getLaunchIntentForPackage(packageName);
                        startActivity(intent);
                    }
                }
            }
        });

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String packageName = pref.getString("shortcut", null);
        if(packageName != null){
            try {
                Drawable icon = getPackageManager()
                        .getApplicationIcon(packageName);
                mImageView.setImageDrawable(icon);

            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }



        Button btnShortCut = findViewById(R.id.btnShortCut);
        btnShortCut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        T05_SharedPreferencesActivity.this,
                        T05_AppListActivity.class);
                startActivityForResult(intent, REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQ_CODE){
            if(resultCode == RESULT_OK){
                ApplicationInfo info = data.getParcelableExtra("info");
                Drawable icon = info.loadIcon(getPackageManager());
                mImageView.setImageDrawable(icon);

                SharedPreferences pref =
                        PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("shortcut", info.packageName);
                editor.apply();
            }
        }
    }
}
