package com.langqu.httpdemo.ui.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.langqu.httpdemo.R;
import com.langqu.httpdemo.base.MyFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends MyFragment {


    public static MainFragment newInstance() {
        // Required empty public constructor
        MainFragment fragment = new MainFragment();
        return  fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initData() {

    }

}
