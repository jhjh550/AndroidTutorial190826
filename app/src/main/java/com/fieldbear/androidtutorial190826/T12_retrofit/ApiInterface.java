package com.fieldbear.androidtutorial190826.T12_retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts")
    Call<List<MyPost>> getPosts();

}
