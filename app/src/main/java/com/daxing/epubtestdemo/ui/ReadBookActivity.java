package com.daxing.epubtestdemo.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.daxing.epubtestdemo.R;
import com.daxing.epubtestdemo.dialog.MainDialog;

import java.io.File;

import static android.view.MotionEvent.ACTION_MOVE;

/**
 * Created by win7 on 2016/8/9.
 */
public class ReadBookActivity extends Activity {
    static float windowWidth = 720;//TODO TEST 获取屏幕大小
    private String readableFileUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_read_book);
        readableFileUrl = getIntent().getParcelableExtra(FileChooseActivity.TEST_READABLE_FILE_URL);
//        File file = new File(readableFileUrl);



        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.liearlay_read);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        final float x = ev.getX();

        switch (ev.getAction()) {
            case ACTION_MOVE:
                Log.i("TEST", "move");
                if (x>0){
                    Log.i("TEST", "向上翻页");
                }else {
                    Log.i("TEST", "向xia翻页");
                }
                break;
            case MotionEvent.ACTION_UP:
                if (x < windowWidth / 3) {
                    Log.i("TEST", "向上翻页");
                } else if (x >= windowWidth / 3 && x <= windowWidth * 2 / 3) {
                    onShowMainActionBar();
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
     * 显示ActionBar
     */
    private void onShowMainActionBar() {

    }


    /**
     * 主菜单对话框
     */
    private void onShowMainMenu() {
        Log.i("TEST", "菜单daikai");
        MainDialog dialog = new MainDialog();

        dialog.initWithContext(this);
        dialog.showDialog();
//         new MainDialog().initWithContext(this).showDialog();
    }

//    public static void measureLay(View lay) {
//        int mW = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
//        int mH = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
//        lay.measure(mW, mH);
//    }
}
