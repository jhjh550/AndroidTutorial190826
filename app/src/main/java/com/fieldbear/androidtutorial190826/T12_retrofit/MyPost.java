package com.fieldbear.androidtutorial190826.T12_retrofit;

import androidx.annotation.NonNull;

public class MyPost {
    int userId;
    int id;
    String title;
    String body;

    public MyPost(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @NonNull
    @Override
    public String toString() {
        return "userId : "+userId+" id: "+id+" title: "+title+" body: "+body;
    }
}
