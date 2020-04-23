package com.langqu.httpdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.langqu.httpdemo.adapter.ImageAdapter;
import com.langqu.httpdemo.base.BaseActivity;
import com.langqu.httpdemo.bean.SearchDataList;
import com.langqu.httpdemo.http.Api;
import com.langqu.httpdemo.http.retrofit.loadfile.RxLoadFlieManager;
import com.langqu.httpdemo.http.retrofit.rx.MyObserver;
import com.langqu.httpdemo.http.retrofit.rx.RxNetWorkUtil;
import com.langqu.httpdemo.observer.ObserverListener;
import com.langqu.httpdemo.observer.ObserverManager;
import com.youth.banner.Banner;
import com.youth.banner.indicator.RectangleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.util.BannerUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends BaseActivity implements OnBannerListener, ObserverListener, View.OnClickListener {

    private Banner banner;
    private List<SearchDataList.DataBean> mDatas = new ArrayList<>();
    private ImageAdapter imageAadapter;
//    private String url3 = Api.baseUrl + "download/503405?id=com.to8to.renovationcompany&ref=appstore.mobile_download&nonce=-2607778849964962178%3A26445986&appClientId=2882303761517485445&appSignature=Dq3tjiWIM0WIB-ojJTPv4Rjp_iQCjwnk3-vcrDKtidE";
    private ProgressBar main_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner = findViewById(R.id.banner);
        main_progress = findViewById(R.id.main_progress);
//        getData();
        banner.setAdapter(imageAadapter = new ImageAdapter(this,mDatas));
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
                SearchDataList list = (SearchDataList) demo;
                List<SearchDataList.DataBean> dataBeans = list.getData();
                mDatas.addAll(dataBeans);
                imageAadapter.updateData(mDatas);
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
//        getData();
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

    @Override
    public void onClick(View v) {
//        Map<String,String> map = new HashMap<>();
//        map.put("start","");
//        map.put("url","download/503405?id=com.to8to.renovationcompany&ref=appstore.mobile_download&nonce=-2607778849964962178%3A26445986&appClientId=2882303761517485445&appSignature=Dq3tjiWIM0WIB-ojJTPv4Rjp_iQCjwnk3-vcrDKtidE");
//        RxNetWorkUtil.downLoad(this, map, new MyObserver(this) {
//            @Override
//            public void onSuccess(Object demo) {
//                String sta = (String) demo;
//            }
//
//            @Override
//            public void onFailure(Throwable e, String errorMsg) {
//
//            }
//        });


    }

    public void onLoad(View view) {

            RxNetWorkUtil.getTestList(this, new MyObserver(this) {
                @Override
                public void onSuccess(Object demo) {
                    SearchDataList list = (SearchDataList) demo;
                }

                @Override
                public void onFailure(Throwable e, String errorMsg) {

                }
            });

//        RxLoadFlieManager.getInstance().downloadPath(AppStoragePath.getCachePath(this)).download(Api.loadUrl, new DownFileCallback() {
//
//            @Override
//            public void onSuccess(DownloadInfo info) {
//
//                Toast.makeText(MainActivity.this, info.getUrl() + "下载完成", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFail(String msg) {
//                Toast.makeText(MainActivity.this, msg + "下载失败", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onProgress(final long totalSize, final long downSize) {
//                // 需要注意的是，如果文件总大小为50M，已下载的大小为10M，
//                // 再次下载时onProgress返回的totalSize是文件总长度
//                // 减去 已下载大小 10M， 即40M，downSize为本次下载的已下载量
//                // 好消息是，我已经在内部做过处理，放心使用吧，但是这个问题大家还是要知道的
//                Log.e("load","---->>>>> 总共大小" + totalSize+"------->>>已下载大小" + downSize);
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        int progress = (int) (downSize * 100 / totalSize);
//                        main_progress.setProgress(progress);
//                    }
//                });
//            }
//        });
    }

    public void stopLoad(View view) {
        RxLoadFlieManager.getInstance().stop(Api.loadUrl);
    }
}
