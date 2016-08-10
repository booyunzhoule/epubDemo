package com.daxing.epubtestdemo.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.daxing.epubtestdemo.R;
import com.daxing.epubtestdemo.ui.util.UICompatUtil;
import com.daxing.epubtestdemo.ui.util.UIHelper;

import static android.view.View.GONE;


/**
 * Created by win7 on 2016/8/9.
 */

public abstract class MenuBaseDialogFrag extends DialogFragment {
    protected FragmentActivity mActivity;

    private Dialog mDialog;
    private DialogInterface.OnCancelListener mCancelListener;
    private DialogInterface.OnDismissListener mDismissListener;

    public MenuBaseDialogFrag() {

    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) { // 这里是为了剔除DialogFragment自身绘制的Frame
            dialog.getWindow().setLayout(getWindowWidth(), getWindowHeight());
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        if (mCancelListener != null) mCancelListener.onCancel(dialog);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (mDismissListener != null) mDismissListener.onDismiss(dialog);
    }

    @NonNull
    @Override
    public final Dialog onCreateDialog(Bundle savedInstanceState) {
        if (mActivity == null) return null;
        if (mDialog == null) {
            mDialog = onCreateDialog(mActivity, savedInstanceState);
        }
        updateBeforeShow();
        return mDialog;
    }

    /**
     * 在显示对话框前，更新相关布局（子类覆盖）
     */
    public void updateBeforeShow() {
    }

    /**
     * 设置上下文（这里必须是继承自FragmentActivity的实例）
     * @param context
     */
    public MenuBaseDialogFrag initWithContext(Context context) {
        if (context instanceof FragmentActivity) {
            mActivity = (FragmentActivity) context;
        }
        return this;
    }



    /**
     * 设置对话框取消监听事件
     * @param cancelListener
     */
    public MenuBaseDialogFrag setOnCancelListener(DialogInterface.OnCancelListener cancelListener) {
        this.mCancelListener = cancelListener;
        return this;
    }

    /**
     * 设置对话框消失的监听事件
     * @param dismissListener
     */
    public MenuBaseDialogFrag setOnDismissListener(DialogInterface.OnDismissListener dismissListener) {
        this.mDismissListener = dismissListener;
        return this;
    }

    /**
     * 判断Dialog是否正在显示
     * @return
     */
    public boolean isDialogShowing() {
        return getDialog() != null && getDialog().isShowing();
    }

    /**
     * 显示对话框
     */
    public final void showDialog() {
        if (isDialogShowing() || mActivity == null) return;
        FragmentTransaction ft = mActivity.getSupportFragmentManager().beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.add(this, getClass().getCanonicalName());
        ft.commitAllowingStateLoss();
    }

    /**
     * 隐藏对话框
     */
    public final void dismissDialog() {
        if (!isDialogShowing()) return;
        dismissAllowingStateLoss();
        mActivity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * 获取Dialog屏幕宽度
     * @return
     */
    public int getWindowWidth() {
        return ViewGroup.LayoutParams.MATCH_PARENT;
    }

    /**
     * 获取Dialog屏幕高度
     */
    public int getWindowHeight() {
        return ViewGroup.LayoutParams.MATCH_PARENT;
    }

    /**
     * 构建默认样式对话框
     * @param activity
     * @param lay
     * @return
     */
    protected final Dialog buildDefaultDialog(Activity activity, View lay) {
        Dialog dialog = new Dialog(activity, R.style.FloatTranslucentStyle);
        mActivity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dialog.setContentView(lay);
        return dialog;
    }

    /**
     * 构建从底部弹出的对话框
     * @param dialog
     */
    protected final Dialog buildBottomInDialog(Dialog dialog) {
        if (dialog == null) return null;
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.BottomDialogAnim);
        return dialog;
    }

    /**
     * 设置深黑半透明背景
     * @param view
     */
    protected final void setDarkTranslucentBg(View view) {
        if (view == null || mActivity == null) return;
        UICompatUtil.setBackground(view, UIHelper.getGradientDrawable(mActivity, 0, R.color.default_trans, true));
    }

    /**
     * 创建Dialog
     * @param activity
     * @param savedInstanceState
     * @return
     */
    public abstract Dialog onCreateDialog(FragmentActivity activity, Bundle savedInstanceState);


}
