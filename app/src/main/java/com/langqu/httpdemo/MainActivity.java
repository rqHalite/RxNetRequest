package com.langqu.httpdemo;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.hjq.toast.ToastUtils;
import com.langqu.httpdemo.base.MyActivity;
import com.langqu.httpdemo.bean.TabEntity;
import com.langqu.httpdemo.ui.fragment.MainFragment;
import com.trello.rxlifecycle2.components.support.RxFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends MyActivity {

    @BindView(R.id.main_layout)
    FrameLayout mainLayout;
    @BindView(R.id.tab_layout)
    CommonTabLayout tabLayout;
    private long exitTime = 0;
    private String[] mTitles = {"首页", "消息", "联系人", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_contact_select, R.mipmap.tab_more_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private Fragment currentFragment = new Fragment();
    private FragmentTransaction transaction;
    private Fragment letFragment;

    @Override
    protected int onCreateLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        hideToolbarView();
        showStatusView(true);
        initFragment();
        setCurrentItem(0);
    }

    private void initFragment() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        tabLayout.setTabData(mTabEntities);
        //tabLayout 的点击事件
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
    }

    private void setCurrentItem(int i) {
        transaction = getSupportFragmentManager().beginTransaction();
        switch (i) {
            case 0:
                //add,hide方式
                curtFragment(MainFragment.newInstance());
                break;
            case 1:
                //add,hide方式
                curtFragment(MainFragment.newInstance());
                break;
            case 2:
                //add,hide方式
                curtFragment(MainFragment.newInstance());
                break;
            case 3:
                //add,hide方式
                curtFragment(MainFragment.newInstance());
                break;
        }
    }

    public void curtFragment(RxFragment targetFragment) {
        if (targetFragment != currentFragment) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if (!targetFragment.isAdded()) { // 判断是否被add过
                // 隐藏当前的fragment，将 下一个fragment 添加进去
                transaction.hide(currentFragment).add(R.id.main_layout, targetFragment).commit();
            } else {
                // 隐藏当前的fragment，显示下一个fragment
                transaction.hide(currentFragment).show(targetFragment).commit();
            }
            currentFragment = targetFragment;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                ToastUtils.show("确定退出当前页面吗？");
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //    private Banner banner;
//    private List<SearchDataList.DataBean> mDatas = new ArrayList<>();
//    private ImageAdapter imageAadapter;
//    //    private String url3 = Api.baseUrl + "download/503405?id=com.to8to.renovationcompany&ref=appstore.mobile_download&nonce=-2607778849964962178%3A26445986&appClientId=2882303761517485445&appSignature=Dq3tjiWIM0WIB-ojJTPv4Rjp_iQCjwnk3-vcrDKtidE";
//    private ProgressBar main_progress;
//
//    @Override
//    protected int onCreateLayout() {
//        return R.layout.activity_main;
//    }
//
//    @Override
//    protected void init(Bundle savedInstanceState) {
//        super.init(savedInstanceState);
//        banner = findViewById(R.id.banner);
//        main_progress = findViewById(R.id.main_progress);
////        getData();
//        banner.setAdapter(imageAadapter = new ImageAdapter(this, mDatas));
//        banner.setIndicator(new RectangleIndicator(this));
//        banner.setIndicatorNormalWidth((int) BannerUtils.dp2px(12));
//        banner.setIndicatorSpace((int) BannerUtils.dp2px(4));
//        banner.setIndicatorRadius(0);
//        banner.setDelayTime(3000);
//        banner.setBannerGalleryEffect(25, 40, 0.14f);
//        banner.setOnBannerListener(this);
//        //注册
//        ObserverManager.getInstance().add(this);
//    }
//
//    private void getData() {
//
////        RxNetWorkUtil.getTestList(this, new MyObserver<SearchDataList>(this) {
////            @Override
////            public void onSuccess(SearchDataList demo) {
////
////            }
////
////            @Override
////            public void onFailure(Throwable e, String errorMsg) {
////
////            }
////        });
//
//
////        Map<String,String> map = new HashMap<>();
////        RxNetWorkUtil.getTestList(this, new MyObserver(this) {
////            @Override
////            public void onSuccess(Object demo) {
////                SearchDataList list = (SearchDataList) demo;
////                List<SearchDataList.DataBean> dataBeans = list.getData();
////                mDatas.addAll(dataBeans);
////                imageAadapter.updateData(mDatas);
////            }
////
////            @Override
////            public void onFailure(Throwable e, String errorMsg) {
////
////            }
////        });
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        banner.start();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        banner.stop();
//    }
//
//    @Override
//    public void OnBannerClick(Object data, int position) {
//        ObserverManager.getInstance().notifyObserver(position + "");
////        getData();
//    }
//
//    @Override
//    public void observerUpDate(String str) {
//        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        ObserverManager.getInstance().removeObserver(this);
//    }
//
//    @Override
//    public void onClick(View v) {
////        Map<String,String> map = new HashMap<>();
////        map.put("start","");
////        map.put("url","download/503405?id=com.to8to.renovationcompany&ref=appstore.mobile_download&nonce=-2607778849964962178%3A26445986&appClientId=2882303761517485445&appSignature=Dq3tjiWIM0WIB-ojJTPv4Rjp_iQCjwnk3-vcrDKtidE");
////        RxNetWorkUtil.downLoad(this, map, new MyObserver(this) {
////            @Override
////            public void onSuccess(Object demo) {
////                String sta = (String) demo;
////            }
////
////            @Override
////            public void onFailure(Throwable e, String errorMsg) {
////
////            }
////        });
//
//
//    }
//
//    public void onLoad(View view) {
//        Map<String, String> map = new HashMap<>();
//        map.put("type", "Android");
//        map.put("page", "1");
//        map.put("count", "2");
//        RxNetWorkUtil.getTestList(this, map, new MyObserver(this) {
//            @Override
//            public void onSuccess(Object demo) {
//                SearchDataList list = (SearchDataList) demo;
//            }
//
//            @Override
//            public void onFailure(Throwable e, String errorMsg) {
//
//            }
//        });
//
////        RxLoadFlieManager.getInstance().downloadPath(AppStoragePath.getCachePath(this)).download(Api.loadUrl, new DownFileCallback() {
////
////            @Override
////            public void onSuccess(DownloadInfo info) {
////
////                Toast.makeText(MainActivity.this, info.getUrl() + "下载完成", Toast.LENGTH_SHORT).show();
////            }
////
////            @Override
////            public void onFail(String msg) {
////                Toast.makeText(MainActivity.this, msg + "下载失败", Toast.LENGTH_SHORT).show();
////            }
////
////            @Override
////            public void onProgress(final long totalSize, final long downSize) {
////                // 需要注意的是，如果文件总大小为50M，已下载的大小为10M，
////                // 再次下载时onProgress返回的totalSize是文件总长度
////                // 减去 已下载大小 10M， 即40M，downSize为本次下载的已下载量
////                // 好消息是，我已经在内部做过处理，放心使用吧，但是这个问题大家还是要知道的
////                Log.e("load","---->>>>> 总共大小" + totalSize+"------->>>已下载大小" + downSize);
////                runOnUiThread(new Runnable() {
////                    @Override
////                    public void run() {
////                        int progress = (int) (downSize * 100 / totalSize);
////                        main_progress.setProgress(progress);
////                    }
////                });
////            }
////        });
//    }
//
//    public void stopLoad(View view) {
//        RxLoadFlieManager.getInstance().stop(Api.loadUrl);
//    }
}
