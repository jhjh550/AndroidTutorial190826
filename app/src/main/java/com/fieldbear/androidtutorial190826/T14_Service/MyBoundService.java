package com.fieldbear.androidtutorial190826.T14_Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class MyBoundService extends Service {
    public MyBoundService() {
    }

    class MyBinder extends Binder{
        public MyBoundService getService(){
            return  MyBoundService.this;
        }
    }

    MyBinder mMyBinder = new MyBinder();
    @Override
    public IBinder onBind(Intent intent) {
        return mMyBinder;
    }

    private Random mRandom = new Random();
    public int getRandomNumber(){
        return mRandom.nextInt(100);
    }
}
