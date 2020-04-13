package com.langqu.httpdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.widget.Toast;

import com.langqu.httpdemo.adapter.ImageAdapter;
import com.langqu.httpdemo.base.BaseActivity;
import com.langqu.httpdemo.bean.DataBean;
import com.langqu.httpdemo.bean.SearchDataList;
import com.langqu.httpdemo.http.ApiServer;
import com.langqu.httpdemo.http.retrofit.RetrofitHelper;
import com.langqu.httpdemo.http.retrofit.rx.BaseReponse;
import com.langqu.httpdemo.http.retrofit.rx.MyObserver;
import com.langqu.httpdemo.http.retrofit.rx.RxNetWorkUtil;
import com.langqu.httpdemo.observer.ObserverListener;
import com.langqu.httpdemo.observer.ObserverManager;
import com.youth.banner.Banner;
import com.youth.banner.indicator.RectangleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.util.BannerUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

public class MainActivity extends BaseActivity implements OnBannerListener, ObserverListener {

    private Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner = findViewById(R.id.banner);

        banner.setAdapter(new ImageAdapter(DataBean.getTestData()));
        banner.setIndicator(new RectangleIndicator(this));
        banner.setIndicatorNormalWidth((int) BannerUtils.dp2px(12));
        banner.setIndicatorSpace((int) BannerUtils.dp2px(4));
        banner.setIndicatorRadius(0);
        banner.setDelayTime(3000);
        banner.setBannerGalleryEffect(25, 40, 0.14f);
        banner.setOnBannerListener(this);
        //注册
        ObserverManager.getInstance().add(this);
    }

    private void getData() {

//        RxNetWorkUtil.getTestList(this, new MyObserver<SearchDataList>(this) {
//            @Override
//            public void onSuccess(SearchDataList demo) {
//
//            }
//
//            @Override
//            public void onFailure(Throwable e, String errorMsg) {
//
//            }
//        });
        Map<String,String> map = new HashMap<>();
        RxNetWorkUtil.getTestList(this, new MyObserver(this) {
            @Override
            public void onSuccess(Object demo) {
                SearchDataList b = (SearchDataList) demo;
            }

            @Override
            public void onFailure(Throwable e, String errorMsg) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        banner.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        banner.stop();
    }

    @Override
    public void OnBannerClick(Object data, int position) {
        ObserverManager.getInstance().notifyObserver(position+"");
        getData();
    }

    @Override
    public void observerUpDate(String str) {
        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ObserverManager.getInstance().removeObserver(this);
    }
}
