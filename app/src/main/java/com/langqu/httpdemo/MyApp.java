package com.langqu.httpdemo;

import android.app.Application;
import android.content.Context;

import com.langqu.httpdemo.greendao.DaoManager;

public class MyApp extends Application {

    private static MyApp myApp;

    @Override
    public void onCreate() {
        super.onCreate();

        myApp = this;

        DaoManager.getInstance().init(this);
    }

    public static MyApp getInstance(){
        return myApp;
    }

    public static Context getContext() {
        return myApp;
    }
}
