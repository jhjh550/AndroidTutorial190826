package com.fieldbear.androidtutorial190826.T12_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.fieldbear.androidtutorial190826.R;
import com.google.android.gms.common.api.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    TextView textViewTitle, textViewBody, textViewCommnets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textViewTitle = findViewById(R.id.textViewTitle);
        textViewBody = findViewById(R.id.textViewBody);
        textViewCommnets = findViewById(R.id.textComments);

        Intent intent = getIntent();
        int postId = intent.getIntExtra("postId", 1);

        getPost(postId);
        getComments(postId);
    }

    private void getComments(int postId){
        ApiInterface mApiInterface = PostManager.getInstance().getApiInterface();
        Call<List<MyComment>> call = mApiInterface.getComments(postId);
        call.enqueue(new Callback<List<MyComment>>() {
            @Override
            public void onResponse(Call<List<MyComment>> call, Response<List<MyComment>> response) {
                List<MyComment> list = response.body();
                for(MyComment comment : list){
                    String str = "\nname: "+comment.name+"\n" +
                            "email : "+comment.email+"\n"+
                            "body : "+comment.body+"\n";
                    textViewCommnets.append(str);
                }
            }

            @Override
            public void onFailure(Call<List<MyComment>> call, Throwable t) {

            }
        });
    }

    private void getPost(int postId){

        ApiInterface mApiInterface = PostManager.getInstance().getApiInterface();
        Call<MyPost> call = mApiInterface.getPost(postId);
        call.enqueue(new Callback<MyPost>() {
            @Override
            public void onResponse(Call<MyPost> call, Response<MyPost> response) {
                MyPost post = response.body();
                textViewTitle.setText(post.title);
                textViewBody.setText(post.body);
            }

            @Override
            public void onFailure(Call<MyPost> call, Throwable t) {

            }
        });
    }
}
