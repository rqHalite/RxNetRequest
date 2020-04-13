package com.langqu.httpdemo.http.retrofit.rx;

import com.langqu.httpdemo.bean.SearchDataList;
import com.langqu.httpdemo.http.retrofit.RetrofitHelper;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.util.List;
import java.util.Map;

public class RxNetWorkUtil {

//    /**
//     * Get 请求demo
//     * @param context
//     * @param observer
//     */
//    public static void getDemoList(RxAppCompatActivity context, MyObserver<SearchDataList> observer){
//        RxRetrofitHelper.getInstance().getTest().compose(RxHelper.observableIO2Main(context))
//                .subscribe(observer);
//    }

    public static void getTestList(RxAppCompatActivity activity,MyObserver observer){
        RxRetrofitHelper.getInstance().
                getTest().compose(RxHelper.observableIO2Main(activity))
                .subscribe(observer);
    }

    public static void getTestList2(RxAppCompatActivity activity, Map<String,String> map, MyObserver observer){
        RxRetrofitHelper.getInstance().
                getTest2(map).compose(RxHelper.observableIO2Main(activity))
                .subscribe(observer);
    }
}
