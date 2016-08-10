package com.daxing.epubtestdemo.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.daxing.epubtestdemo.R;
import com.daxing.epubtestdemo.ui.popmenu.DemoPopMenu;
import com.daxing.epubtestdemo.ui.util.UIHelper;

import static android.R.attr.id;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by win7 on 2016/8/9.
 */

public class MainDialogMenu extends MenuBaseDialogFrag implements View.OnClickListener {
    private boolean isPublic = false ;
    private boolean  isFold = false ;
    private boolean isNightModel = true;
    private FragmentActivity activity;
    private View view;
    private DemoPopMenu popupMenu;

    private ImageView backImage,publicImage,toolImage,modelImage;
    private TextView lastChapterText,nextChapterText;
    private FrameLayout catalogView,lightView,txtSizeView,settingView;
    private SeekBar mSeekBar;
    private LinearLayout bgView;
    @Override
    public Dialog onCreateDialog(FragmentActivity activity, Bundle savedInstanceState) {
        this.activity = activity;
        view = LayoutInflater.from(activity).inflate(R.layout.dialog_main,null);

        backImage = (ImageView) view.findViewById(R.id.image_read_book_back);
        publicImage = (ImageView) view.findViewById(R.id.image_read_book_public);
        toolImage = (ImageView) view.findViewById(R.id.image_read_book_tool_expendable);
        bgView = (LinearLayout) view.findViewById(R.id.view_menu_bg);
        modelImage = (ImageView) view.findViewById(R.id.image_dialog_watch_model);
        lastChapterText = (TextView) view.findViewById(R.id.tv_dialog_main_last_chapter);
        nextChapterText = (TextView) view.findViewById(R.id.tv_dialog_main_next_chapter);
        mSeekBar = (SeekBar)view.findViewById(R.id.seekbar_main_menu) ;
        catalogView = (FrameLayout)view.findViewById(R.id.view_read_main_menu_catalog) ;
        lightView = (FrameLayout)view.findViewById(R.id.view_read_main_menu_light) ;
        txtSizeView = (FrameLayout)view.findViewById(R.id.view_read_main_menu_txt_size) ;
        settingView = (FrameLayout)view.findViewById(R.id.view_read_main_menu_setting) ;

        UIHelper.setNoFastClickListener(backImage,this);
        UIHelper.setNoFastClickListener(publicImage,this);
        UIHelper.setNoFastClickListener(toolImage,this);
        UIHelper.setNoFastClickListener(bgView,this);
        UIHelper.setNoFastClickListener(modelImage,this);
        UIHelper.setNoFastClickListener(lastChapterText,this);
        UIHelper.setNoFastClickListener(nextChapterText,this);
        UIHelper.setNoFastClickListener(catalogView,this);
        UIHelper.setNoFastClickListener(lightView,this);
        UIHelper.setNoFastClickListener(txtSizeView,this);
        UIHelper.setNoFastClickListener(settingView,this);

        popupMenu = new DemoPopMenu(activity,view.findViewById(R.id.image_read_book_tool_expendable));
        popupMenu.getMenuInflater().inflate(R.menu.menu_tool,popupMenu.getMenu());
        popupMenu.setMenuImageView(toolImage);

        Dialog dialog = buildDefaultDialog(activity,view);
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }

//    @Override
//    public int getWindowHeight() {
//        Log.i("TEST", "菜单height");
//        return ViewGroup.LayoutParams.WRAP_CONTENT;
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.image_read_book_back:
                dismissDialog();
                activity.finish();
                break;
            case R.id.image_read_book_public:
                onBookPublicListener();
                break;
            case R.id.image_read_book_tool_expendable:
                onToolFoldListener();
                break;
            case R.id.view_menu_bg:
                dismissDialog();
                break;
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

    }

    /**
     * 设置字体大小
     */
    private void onSetTxtSizeListener() {
    }

    /**
     * 设置屏幕亮度
     */
    private void onSetLightListener() {

    }

    /**
     * 显示章节菜单
     */
    private void onShowCatalogLister() {

    }

    /**
     * 跳转到下一章节
     */
    private void onTurnToNextChapterListener() {

    }

    /**
     * 跳转到上一章节
     */
    private void onTurnToLastChapterListener() {
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

    /**
     * 工具展开
     */
    private void onToolFoldListener() {
            popupMenu.show();
    }

    /**
     * 书是否公开
     */
    private void onBookPublicListener() {
            if (isPublic){
                isPublic = false;
                ((ImageView) view.findViewById(R.id.image_read_book_public)).setImageResource(R.drawable.zjb_icon_read_book_no_public);
            }else{
                isPublic = true;
                ((ImageView) view.findViewById(R.id.image_read_book_public)).setImageResource(R.drawable.zjb_icon_read_book_public);
            }
    }


}
