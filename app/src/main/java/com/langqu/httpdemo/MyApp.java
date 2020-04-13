package com.langqu.httpdemo;

import android.app.Application;
import android.content.Context;

public class MyApp extends Application {

    private static MyApp myApp;

    @Override
    public void onCreate() {
        super.onCreate();

        myApp = this;
    }

    public static MyApp getInstance(){
        return myApp;
    }

    public static Context getContext() {
        return myApp;
    }
}
