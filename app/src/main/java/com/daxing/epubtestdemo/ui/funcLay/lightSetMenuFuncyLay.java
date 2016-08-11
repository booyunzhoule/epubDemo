package com.daxing.epubtestdemo.ui.funcLay;

import android.content.Context;
import android.util.AttributeSet;

import com.daxing.epubtestdemo.R;
import com.daxing.epubtestdemo.ui.funcLay.base.BaseFuncyLay;

/**
 * Created by win7 on 2016/8/11.
 */

public class LightSetMenuFuncyLay extends BaseFuncyLay {

    public LightSetMenuFuncyLay(Context context) {
        super(context);
    }

    public LightSetMenuFuncyLay(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LightSetMenuFuncyLay(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getContentLayId() {
        return R.layout.menu_dialog_set_light;
    }

    @Override
    public void initView(AttributeSet attrs) {

    }

    @Override
    public void initData() {

    }
}
