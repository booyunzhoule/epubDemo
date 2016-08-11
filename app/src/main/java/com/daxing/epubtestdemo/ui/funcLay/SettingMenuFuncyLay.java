package com.daxing.epubtestdemo.ui.funcLay;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioGroup;

import com.daxing.epubtestdemo.R;
import com.daxing.epubtestdemo.ui.funcLay.base.BaseFuncyLay;

/**
 * Created by win7 on 2016/8/11.
 */

public class  SettingMenuFuncyLay extends BaseFuncyLay implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup radioGroup;
    public SettingMenuFuncyLay(Context context) {
        super(context);
    }

    public SettingMenuFuncyLay(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SettingMenuFuncyLay(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getContentLayId() {
        return R.layout.menu_dialog_read_set;
    }

    @Override
    public void initView(AttributeSet attrs) {
        radioGroup = (RadioGroup)findViewById(R.id.radiogroup_dialog_menu_set_page_turner_model);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

    }
}
