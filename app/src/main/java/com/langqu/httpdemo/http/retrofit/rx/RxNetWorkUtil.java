package com.langqu.httpdemo.http.retrofit.rx;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class RxNetWorkUtil {


    public static void getTestList(RxAppCompatActivity activity, MyObserver observer) {
        RxRetrofitHelper.getInstance().
                getTest().compose(RxHelper.observableIO2Main(activity))
                .subscribe(observer);
    }

    public static void getTestList2(RxAppCompatActivity activity, Map<String, String> map, MyObserver observer) {
        RxRetrofitHelper.getInstance().
                getTest2(map).compose(RxHelper.observableIO2Main(activity))
                .subscribe(observer);
    }

    public static void downLoad(RxAppCompatActivity activity, Map<String, String> map, MyObserver observer) {
        RxRetrofitHelper.getInstance().
                download(map.get("start"), map.get("url")).compose(RxHelper.observableIO2Main(activity))
                .subscribe(observer);
    }
}
