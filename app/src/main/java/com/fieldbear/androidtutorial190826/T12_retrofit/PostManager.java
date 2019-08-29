package com.fieldbear.androidtutorial190826.T12_retrofit;

public class PostManager {
    private static PostManager manger;
    private ApiInterface apiInterface;

    public static PostManager getInstance(){
        if(manger == null)
            manger = new PostManager();

        return manger;
    }

    public ApiInterface getApiInterface() {
        return apiInterface;
    }
}
