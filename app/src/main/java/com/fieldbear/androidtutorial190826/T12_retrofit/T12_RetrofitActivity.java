package com.fieldbear.androidtutorial190826.T12_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.fieldbear.androidtutorial190826.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class T12_RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t12__retrofit);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<MyPost>> posts = apiInterface.getPosts();
    }
}
