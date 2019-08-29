package com.fieldbear.androidtutorial190826.T12_retrofit;

public class PostManger {
    private static PostManger manger;
    private ApiInterface apiInterface;

    public static PostManger getInstance(){
        if(manger == null)
            manger = new PostManger();

        return manger;
    }

    public ApiInterface getApiInterface() {
        return apiInterface;
    }
}
