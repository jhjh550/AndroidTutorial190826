package com.fieldbear.androidtutorial190826.T12_retrofit;

import org.w3c.dom.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("posts")
    Call<List<MyPost>> getPosts();

    @GET("posts/{id}")
    Call<MyPost> getPost(@Path("id") int postId);

    @GET("posts/{id}/comments")
    Call<List<MyComment>> getComments(@Path("id") int postId);

}
