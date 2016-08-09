package com.daxing.epubtestdemo.funcLay.base;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by win7 on 2016/8/9.
 */

public class bookView extends BaseFuncyLay {

    public bookView(Context context) {
        super(context);
    }

    public bookView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    public bookView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getContentLayId() {
        return 0;
    }

    @Override
    public void initView(AttributeSet attrs) {

    }

    @Override
    public void initData() {

    }
}
