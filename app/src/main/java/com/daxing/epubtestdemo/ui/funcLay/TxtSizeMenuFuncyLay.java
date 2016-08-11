package com.daxing.epubtestdemo.ui.funcLay;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.daxing.epubtestdemo.R;
import com.daxing.epubtestdemo.ui.funcLay.base.BaseFuncyLay;
import com.daxing.epubtestdemo.ui.util.UIHelper;
import com.daxing.epubtestdemo.ui.view.ReadManipulator;

import static com.daxing.epubtestdemo.R.id.tv_set_txt_size_menu_large;

/**
 * Created by win7 on 2016/8/11.
 */

public class TxtSizeMenuFuncyLay extends BaseFuncyLay implements View.OnClickListener {
    private TextView largeText,smallText;

    public TxtSizeMenuFuncyLay(Context context) {
        super(context);
    }

    public TxtSizeMenuFuncyLay(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TxtSizeMenuFuncyLay(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getContentLayId() {
        return R.layout.menu_dialog_set_txt_size;
    }

    @Override
    public void initView(AttributeSet attrs) {
        largeText = (TextView)findViewById(tv_set_txt_size_menu_large);
        smallText = (TextView)findViewById(R.id.tv_set_txt_size_menu_small);
        UIHelper.setNoFastClickListener(largeText,this);
        UIHelper.setNoFastClickListener(smallText,this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_set_txt_size_menu_large:
//                ReadManipulator.setTextSizeLarge();
                break;
            case R.id.tv_set_txt_size_menu_small:
//                ReadManipulator.setTextSizeSmall();
                break;
        }
    }
}
