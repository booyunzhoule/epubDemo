package com.daxing.epubtestdemo.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.daxing.epubtestdemo.R;
import com.daxing.epubtestdemo.ui.funcLay.MainMenuFuncyLay;
import com.daxing.epubtestdemo.ui.util.UIHelper;

/**
 * Created by win7 on 2016/8/9.
 */

public class MainDialogMenu extends MenuBaseDialogFrag implements View.OnClickListener, PopupWindow.OnDismissListener {
    private boolean isPublic = false ;
    private boolean  isFold = false ;
    private TextView txtView;
    private FragmentActivity activity;
    private View view;
    private PopupWindow popupMenu;
    private ImageView backImage,publicImage,toolImage;
    private LinearLayout containerView,bgView;
    private MainMenuFuncyLay mainMenuFuncyLay;

    public void setTxtView(TextView txtView) {
        this.txtView = txtView;
    }

    @Override
    public Dialog onCreateDialog(FragmentActivity activity, Bundle savedInstanceState) {
        this.activity = activity;
        view = LayoutInflater.from(activity).inflate(R.layout.dialog_main,null);

        backImage = (ImageView) view.findViewById(R.id.image_read_book_back);
        publicImage = (ImageView) view.findViewById(R.id.image_read_book_public);
        toolImage = (ImageView) view.findViewById(R.id.image_read_book_tool_expendable);
        containerView = (LinearLayout)view.findViewById(R.id.view_menu_container);
        bgView = (LinearLayout) view.findViewById(R.id.view_menu_bg);
        mainMenuFuncyLay = new MainMenuFuncyLay(activity);
        mainMenuFuncyLay.setParentView(containerView);
        mainMenuFuncyLay.setTxtView(txtView);
        mainMenuFuncyLay.setMainDialogMenu(this);
        containerView.addView(mainMenuFuncyLay);
        UIHelper.setNoFastClickListener(backImage,this);
        UIHelper.setNoFastClickListener(publicImage,this);
        UIHelper.setNoFastClickListener(toolImage,this);
        UIHelper.setNoFastClickListener(bgView,this);

        Dialog dialog = buildDefaultDialog(activity,view);
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
            case R.id.view_menu_tool_container:
                popupMenu.dismiss();
                break;
            case R.id.checkbox_tool_menu_label:
                onLabelListener();
                break;
            case R.id.checkbox_tool_menu_collect:
                onCollectListener();
                break;
            case R.id.image_tool_menu_transpond:
                onTranSpondListener();
                break;
        }
    }

    /**
     * 转发
     */
    private void onTranSpondListener() {

    }

    /**
     * 收藏
     */
    private void onCollectListener() {

    }

    /**
     * 添加书签
     */
    private void onLabelListener() {

    }

    /**
     * 工具展开
     */
    private void onToolFoldListener() {
        toolImage.setImageResource(R.drawable.zjb_icon_menu_unfold);
        ViewGroup menuView = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.menu_main_popup_tool, null, true);
         popupMenu = new PopupWindow(menuView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        popupMenu.setOutsideTouchable(true);
        popupMenu.setOnDismissListener(this);
        popupMenu.showAsDropDown(toolImage);
        UIHelper.setNoFastClickListener(menuView.findViewById(R.id.view_menu_tool_container),this);
        UIHelper.setNoFastClickListener(menuView.findViewById(R.id.checkbox_tool_menu_label),this);
        UIHelper.setNoFastClickListener(menuView.findViewById(R.id.checkbox_tool_menu_collect),this);
        UIHelper.setNoFastClickListener(menuView.findViewById(R.id.image_tool_menu_transpond),this);
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

//    @Override
//    public void onDismiss(PopupMenu menu) {
//
//    }

    @Override
    public void onDismiss() {
        toolImage.setImageResource(R.drawable.zjb_icon_menu_fold);
    }
}
