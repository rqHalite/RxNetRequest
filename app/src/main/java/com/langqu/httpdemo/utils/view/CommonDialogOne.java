package com.langqu.httpdemo.utils.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.langqu.httpdemo.R;
import com.langqu.httpdemo.utils.screentools.ScreenAdapterTools;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Rock on 2018/8/10.
 * <p>
 * 本demo弹出框共分为3种
 * 1、普通弹出窗，点击框外不消失
 * 2、提示弹出框，点击框外消失
 * 3、弹出框的数据交换弹框
 */

public abstract class CommonDialogOne extends Dialog implements View.OnClickListener {

    @BindView(R.id.dialogone_content)
    TextView dialogoneContent;
    @BindView(R.id.dialogone_ensure)
    LinearLayout dialogoneEnsure;
    @BindView(R.id.dialogone_cancel)
    LinearLayout dialogoneCancel;
    private WindowManager windowManager;
    private boolean cancal = false;//用来判断是否可点击弹框外消失弹框
    private static Context mContext;
    private View view;


    public CommonDialogOne(@NonNull Context context, boolean weatherClickhide) {
        super(context);
        this.mContext = context;
        windowManager = ((Activity) context).getWindowManager();
        this.cancal = weatherClickhide;
        getWindow().setWindowAnimations(R.style.dialogstyle_vertical);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = LayoutInflater.from(mContext).inflate(R.layout.diaolog_one_type, null);
        ScreenAdapterTools.getInstance().loadView(view);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//去除屏幕的title
        setContentView(view);//设置diaolog的样式布局
        ButterKnife.bind(this, view);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);//设置dialog背景为透明色
        getWindow().setGravity(Gravity.CENTER);//设置dialog的位置
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);//获取屏幕的宽和高
        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();//获取弹框当前的参数
        layoutParams.width = (int) (point.x * 0.8);
        setCanceledOnTouchOutside(cancal);//设置点击屏幕dialog不消失
        onWindowAttributesChanged(layoutParams);  //改变dialog窗口的位置
        getWindow().setAttributes(layoutParams);
        initView();//初始化view
    }


    private void initView() {
        findViewById(R.id.dialogone_cancel).setOnClickListener(this);
        findViewById(R.id.dialogone_ensure).setOnClickListener(this);
//        contentView = findViewById(R.id.dialogone_content);
//
//        contentView.setText(contentStr);
    }

//    @OnClick({R.id.dialogone_cancel, R.id.dialogone_ensure})
//    public void onclick(View view) {
//
//    }

    public abstract void onCancel();

    public abstract void onEnsure();

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialogone_cancel:
                onCancel();
                dismiss();
                break;

            case R.id.dialogone_ensure:
                onEnsure();
                dismiss();
                break;
        }
    }
}
