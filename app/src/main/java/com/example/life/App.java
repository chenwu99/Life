package com.example.life;

import android.app.Application;

import cn.bmob.v3.Bmob;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Bmob.initialize(this, "81ca4a8ac020a749a97c4b8c041af16d");

    }
}
