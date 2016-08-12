package com.daxing.epubtestdemo.ui.funcLay;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.daxing.epubtestdemo.R;
import com.daxing.epubtestdemo.ui.dialog.CatalogAndLabelDialogFrag;
import com.daxing.epubtestdemo.ui.dialog.MainDialogMenu;
import com.daxing.epubtestdemo.ui.funcLay.base.BaseFuncyLay;
import com.daxing.epubtestdemo.ui.util.UIHelper;


/**
 * Created by win7 on 2016/8/11.
 */

public class MainMenuFuncyLay extends BaseFuncyLay implements View.OnClickListener {
    private ImageView modelImage;
    private TextView lastChapterText, nextChapterText;
    private FrameLayout catalogView, lightView, txtSizeView, settingView;
    private SeekBar mSeekBar;
    private boolean isNightModel = true;
    private LinearLayout parentView;
    private TextView txtView;
    private MainDialogMenu mainDialogMenu;

    public void setMainDialogMenu(MainDialogMenu mainDialogMenu) {
        this.mainDialogMenu = mainDialogMenu;
    }

    public MainMenuFuncyLay(Context context) {
        super(context);
    }

    public MainMenuFuncyLay(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MainMenuFuncyLay(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getContentLayId() {
        return R.layout.menu_dialog_main;
    }

    @Override
    public void initView(AttributeSet attrs) {
//        parentView = (LinearLayout) this.getParent();

        modelImage = (ImageView) findViewById(R.id.image_dialog_watch_model);
        lastChapterText = (TextView) findViewById(R.id.tv_dialog_main_last_chapter);
        nextChapterText = (TextView) findViewById(R.id.tv_dialog_main_next_chapter);
        mSeekBar = (SeekBar) findViewById(R.id.seekbar_main_menu);
        catalogView = (FrameLayout) findViewById(R.id.view_read_main_menu_catalog);
        lightView = (FrameLayout) findViewById(R.id.view_read_main_menu_light);
        txtSizeView = (FrameLayout) findViewById(R.id.view_read_main_menu_txt_size);
        settingView = (FrameLayout) findViewById(R.id.view_read_main_menu_setting);

        UIHelper.setNoFastClickListener(modelImage, this);
        UIHelper.setNoFastClickListener(lastChapterText, this);
        UIHelper.setNoFastClickListener(nextChapterText, this);
        UIHelper.setNoFastClickListener(catalogView, this);
        UIHelper.setNoFastClickListener(lightView, this);
        UIHelper.setNoFastClickListener(txtSizeView, this);
        UIHelper.setNoFastClickListener(settingView, this);
    }

    @Override
    public void initData() {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_dialog_watch_model:
                onChangeModelListener();
                break;
            case R.id.tv_dialog_main_last_chapter:
                onTurnToLastChapterListener();
                break;
            case R.id.tv_dialog_main_next_chapter:
                onTurnToNextChapterListener();
                break;
            case R.id.view_read_main_menu_catalog:
                onShowCatalogLister();
                break;
            case R.id.view_read_main_menu_light:
                onSetLightListener();
                break;
            case R.id.view_read_main_menu_txt_size:
                onSetTxtSizeListener();
                break;
            case R.id.view_read_main_menu_setting:
                onSettingListener();
                break;
        }
    }

    /**
     * 其他设置
     */
    private void onSettingListener() {
        parentView.removeView(this);
        parentView.addView(new SettingMenuFuncyLay(this.getContext()));
    }

    /**
     * 设置字体大小
     */
    private void onSetTxtSizeListener() {
        TxtSizeMenuFuncyLay txtSizeMenuFuncyLay = new TxtSizeMenuFuncyLay(this.getContext());
        txtSizeMenuFuncyLay.setTxtView(txtView);
        parentView.removeView(this);
        parentView.addView(txtSizeMenuFuncyLay);
    }

    /**
     * 设置屏幕亮度
     */
    private void onSetLightListener() {
        parentView.removeView(this);
        parentView.addView(new LightSetMenuFuncyLay(this.getContext()));
    }

    /**
     * 显示章节菜单
     */
    private void onShowCatalogLister() {
        mainDialogMenu.dismissDialog();
        new CatalogAndLabelDialogFrag().initWithContext(this.getContext()).showDialog();
    }

    /**
     * 跳转到下一章节
     */
    private void onTurnToNextChapterListener() {
        Log.i("Test","下一章");
    }

    /**
     * 跳转到上一章节
     */
    private void onTurnToLastChapterListener() {
        Log.i("Test","上一章");
    }

    /**
     * 改变阅读模式：日间模式和夜间模式
     */
    private void onChangeModelListener() {

        if (isNightModel){
            isNightModel = false ;
            modelImage.setImageResource(R.drawable.zkn_icon_read_daytime_model);
        }else{
            isNightModel = true ;
            modelImage.setImageResource(R.drawable.zjb_icon_read_night_model);
        }
    }

    public void setParentView(LinearLayout parentView) {
        this.parentView = parentView;
    }

    public void setTxtView(TextView txtView) {
        this.txtView = txtView;
    }
}
