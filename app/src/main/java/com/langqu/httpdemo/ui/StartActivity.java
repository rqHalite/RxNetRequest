package com.langqu.httpdemo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.langqu.httpdemo.R;
import com.langqu.httpdemo.base.MyActivity;

public class StartActivity extends MyActivity {
    @Override
    protected int onCreateLayout() {
        return R.layout.activity_start;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        hideToolbarView();
        showStatusView(false);
    }
}
