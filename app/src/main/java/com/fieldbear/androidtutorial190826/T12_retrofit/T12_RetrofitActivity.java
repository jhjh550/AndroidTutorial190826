package com.fieldbear.androidtutorial190826.T12_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.fieldbear.androidtutorial190826.R;
import com.fieldbear.androidtutorial190826.T07_ViewPager.MyPagerAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class T12_RetrofitActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    RecyclerView postsReyclerView;
    PostAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t12__retrofit);

        postsReyclerView = findViewById(R.id.postsReyclerView);
        postsReyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PostAdapter();
        postsReyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
        getPosts();


    }

    private void getPosts(){
        Call<List<MyPost>> call = apiInterface.getPosts();
        call.enqueue(new Callback<List<MyPost>>() {
            @Override
            public void onResponse(Call<List<MyPost>> call, Response<List<MyPost>> response) {
                if(response.isSuccessful() == false){
                    return;
                }

                List<MyPost> list = response.body();
                showPosts(list);

            }

            @Override
            public void onFailure(Call<List<MyPost>> call, Throwable t) {

            }
        });

    }

    private void showPosts(List<MyPost> list){
        adapter.setPosts(list);
    }
}
