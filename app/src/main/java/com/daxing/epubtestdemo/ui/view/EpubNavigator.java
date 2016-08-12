package com.daxing.epubtestdemo.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daxing.epubtestdemo.R;
import com.daxing.epubtestdemo.ui.dialog.MainDialogMenu;

import static android.view.MotionEvent.ACTION_MOVE;

/**
 * Created by win7 on 2016/8/10.
 */

public class EpubNavigator extends LinearLayout {
    private float windowWidth = 640;
    //    private Toolbar mToolBar;
    private Context mContext = null;
    //TODO TEST
    private  static TextView txtView;
    private static float txtSize = 10;
//    final  float fontScale = this.getResources().getDisplayMetrics().scaledDensity;
    public EpubNavigator(Context context) {
        this(context, null);
    }

    public EpubNavigator(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        initView(context);
    }

    public EpubNavigator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.read_manipulator, this, true);
        txtView = (TextView) findViewById(R.id.tv_read_book_textview);
        Log.i("Test", txtView.getTextSize() + "");
        txtSize = txtView.getTextSize();

    }

    public static void setTextSizeLarge() {

//        txtView.setTextSize((int) (txtView.getTextSize() / fontScale + 0.5f) + 1);
    }

    public static void setTextSizeSmall() {
        txtSize = txtView.getTextSize();
        txtView.setTextSize(txtSize - 1);
    }

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
        MainDialogMenu mainDialogMenu =  new MainDialogMenu();
        mainDialogMenu.setTxtView(txtView);
        mainDialogMenu.initWithContext(mContext).showDialog();
    }

}
