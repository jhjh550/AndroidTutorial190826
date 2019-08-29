package com.fieldbear.androidtutorial190826.T12_retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fieldbear.androidtutorial190826.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class T12_RetrofitActivity extends AppCompatActivity {

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


        PostManager.getInstance().setApiInterface(
                        retrofit.create(ApiInterface.class));
        getPosts();

        Button btnWrite = findViewById(R.id.btnWrite);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPost();
            }
        });


    }

    private void createPost(){
        MyPost post = new MyPost(3,3, "New Title", "New Text");
        Call<MyPost> call = PostManager.getInstance().getApiInterface().createPost(post);
        call.enqueue(new Callback<MyPost>() {
            @Override
            public void onResponse(Call<MyPost> call, Response<MyPost> response) {
                if(response.isSuccessful() == false){
                    Toast.makeText(T12_RetrofitActivity.this,
                            "error : "+response.code(), Toast.LENGTH_SHORT).show();
                }else{
                    MyPost post = response.body();
                    Toast.makeText(T12_RetrofitActivity.this,
                            "result : "+post.toString(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<MyPost> call, Throwable t) {

            }
        });
    }

    private void getPosts(){
        ApiInterface apiInterface = PostManager.getInstance().getApiInterface();
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
