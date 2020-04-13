package com.langqu.httpdemo.http.retrofit.rx;

import com.langqu.httpdemo.http.Api;
import com.langqu.httpdemo.http.ApiServer;
import com.langqu.httpdemo.http.OkHttpClientHelper;
import com.langqu.httpdemo.http.retrofit.RetrofitHelper;
import com.langqu.httpdemo.http.retrofit.nethelper.gsonconverter.ResponseConverterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RxRetrofitHelper {
    private static ApiServer helper;
    private Retrofit mRetrofit;
    private final OkHttpClient mClient;


    private RxRetrofitHelper() {
        mClient = OkHttpClientHelper.getInstance().getOkHttpClient();
    }

    //单例模式 对象唯一
    public static ApiServer getInstance() {
        if (helper == null) {
            synchronized (RxRetrofitHelper.class) {
                if (helper == null) {
                    helper = new RxRetrofitHelper().getApi();
                }
            }
        }
        return helper;
    }

    public ApiServer getApi() {
// 初始化Retrofit
        ApiServer apiUrl = getRetrofit().create(ApiServer.class);
        return apiUrl;
    }

    //构造Retrofit对象
    public Retrofit getRetrofit() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Api.baseUrl)                                       //域名访问地址 这里只是为了方便demo单独写一个，最好的方式是在builderconfig里面配置，只要修改一下Build Varilant 就可以切换生产环境
                    .addConverterFactory(ResponseConverterFactory.create())    //在和后台配合开发的过程中 设计返回数据模型解决解析异常
//                      .addConverterFactory(JsonConverterEncryptionFactory.create())    // 数据加解密类型
//                      .addConverterFactory(GsonConverterFactory.create())      //1、转换器 添加gson支持      具体情况看后台的数据basemodle
//                      .addConverterFactory(FastJsonConverterFactory.create())  //2转换器 添加fastjason支持
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())  //添加RxJava支持
                    .client(mClient)                                           //关联ok3 设置client
                    .build();
        }
        return mRetrofit;
    }

}
