package com.langqu.httpdemo;

import android.app.Application;
import android.content.Context;

import com.langqu.httpdemo.greendao.DaoManager;
import com.langqu.httpdemo.utils.screentools.ScreenAdapterTools;
import com.langqu.httpdemo.utils.umeng.UmengUtils;

public class MyApp extends Application {

    private static MyApp myApp;

    @Override
    public void onCreate() {
        super.onCreate();

        myApp = this;

        DaoManager.getInstance().init(this);
        UmengUtils.init(this);
        ScreenAdapterTools.init(this);
    }

    public static MyApp getInstance(){
        return myApp;
    }

    public static Context getContext() {
        return myApp;
    }
}
