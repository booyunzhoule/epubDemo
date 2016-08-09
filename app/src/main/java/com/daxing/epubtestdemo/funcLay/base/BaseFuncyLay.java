package com.daxing.epubtestdemo.funcLay.base;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by win7 on 2016/8/9.
 */

public abstract class BaseFuncyLay extends LinearLayout {
    private Context mContext;

    public BaseFuncyLay(Context context) {

        this(context,null);
    }

    public BaseFuncyLay(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BaseFuncyLay(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        this.mContext = context;
        int layId = getContentLayId();
        View contentLay = getContentLay();
        if (layId <= 0 && contentLay == null) throw new IllegalArgumentException("content layId can not be leq 0, when getContentLay return null!");
        if (layId > 0) {
            LayoutInflater.from(getContext()).inflate(layId, this, true);
        } else if (contentLay != null) {
            addView(contentLay);
        }
        initView(attrs);
    }

    /**
     * 当getContentLayId返回无效值时，可以通过覆盖此方法获取内容布局
     * @return
     */
    protected View getContentLay() {
        return null;
    }

    /**
     * 子类可以实现自己广播监听器的处理
     * @param action
     */
    public void onReceiveBroadcast(String action, Bundle data) {
    }

    /**
     * Activity onResume时调用
     */
    public void doOnResume() {
    }

    /**
     * Activity onStop时调用
     */
    public void doOnStop() {
    }

    /**
     * 获取内容布局id
     * @return
     */
    public abstract int getContentLayId();

    /**
     * 初始化布局
     */
    public abstract void initView(AttributeSet attrs);

    /**
     * 初始化数据
     */
    public abstract void initData();
}
