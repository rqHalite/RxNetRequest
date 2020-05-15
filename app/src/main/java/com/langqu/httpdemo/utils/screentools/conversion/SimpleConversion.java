package com.langqu.httpdemo.utils.screentools.conversion;

import android.view.View;

import com.langqu.httpdemo.utils.screentools.loadviewhelper.AbsLoadViewHelper;


/**
 * Only adapter width/height/padding/margin
 * Created by zhangyuwan0 on 2018/3/21.
 */

public class SimpleConversion implements IConversion {

    @Override
    public void transform(View view, AbsLoadViewHelper loadViewHelper) {
        if (view.getLayoutParams() != null) {
            loadViewHelper.loadWidthHeightFont(view);
            loadViewHelper.loadPadding(view);
            loadViewHelper.loadLayoutMargin(view);
        }
    }

}
