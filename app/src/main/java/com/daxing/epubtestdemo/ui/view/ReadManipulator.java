package com.daxing.epubtestdemo.ui.view;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.daxing.epubtestdemo.ui.activity.ReadBookActivity;
import com.daxing.epubtestdemo.ui.dialog.MainDialogMenu;

import static android.view.MotionEvent.ACTION_MOVE;

/**
 * Created by win7 on 2016/8/10.
 */

public class ReadManipulator extends LinearLayout {
    private float windowWidth = 640;
//    private Toolbar mToolBar;
    private Context mContext;



    public ReadManipulator(Context context) {
        super(context);
        mContext = context;
    }

    public ReadManipulator(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public ReadManipulator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

//    public void setmToolBar(Toolbar mToolBar) {
//        this.mToolBar = mToolBar;
//    }

    public boolean dispatchTouchEvent(MotionEvent ev) {
        final float x = ev.getX();

        switch (ev.getAction()) {
            case ACTION_MOVE:
                Log.i("TEST", "move");
                if (x > 0) {
                    Log.i("TEST", "向上翻页");
                } else {
                    Log.i("TEST", "向xia翻页");
                }
                break;

            case MotionEvent.ACTION_UP:
                if (x < windowWidth / 3) {
                    Log.i("TEST", "向上翻页");
                } else if (x >= windowWidth / 3 && x <= windowWidth * 2 / 3) {
//                    onShowMainActionBar();
                    onShowMainMenu();
                    Log.i("TEST", "菜单");
                } else if (x > windowWidth * 2 / 3) {
                    Log.i("TEST", "向下翻页");
                }
                break;
        }
        return true;
    }

    /**
     * 主菜单对话框
     */
    private void onShowMainMenu() {
        new MainDialogMenu().initWithContext(mContext).showDialog();
    }

}
