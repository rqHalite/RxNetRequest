package com.langqu.httpdemo.ui.fragment;


import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.langqu.httpdemo.R;
import com.langqu.httpdemo.base.MyFragment;
import com.langqu.httpdemo.utils.view.CommonDialogOne;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends MyFragment {


    @BindView(R.id.main_text)
    TextView mainText;

    public static MainFragment newInstance() {
        // Required empty public constructor
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.main_text})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_text:
                CommonDialogOne dialogOne = new CommonDialogOne(getActivity(),false) {
                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onEnsure() {

                    }
                };
                dialogOne.show();
                break;
        }
    }
}
