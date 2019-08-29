package com.fieldbear.androidtutorial190826.T12_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.fieldbear.androidtutorial190826.R;
import com.google.android.gms.common.api.Api;

public class DetailActivity extends AppCompatActivity {

    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mApiInterface = PostManager.getInstance().getApiInterface();
        getPost();
    }

    private void getPost(){
        Intent intent = getIntent();
        int postId = intent.getIntExtra("postId", 1);
        Toast.makeText(this, "postId: "+postId, Toast.LENGTH_SHORT).show();
    }
}
