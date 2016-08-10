package com.daxing.epubtestdemo.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import android.view.Window;
import android.view.WindowManager;
import com.daxing.epubtestdemo.R;
import com.daxing.epubtestdemo.ui.util.UIHelper;
import com.daxing.epubtestdemo.ui.view.ReadManipulator;


/**
 * Created by win7 on 2016/8/9.
 */
public class ReadBookActivity extends FragmentActivity {
    static float windowWidth = 720;//TODO TEST 获取屏幕大小
    private String readableFileUrl;
//    private Toolbar toolbar;
    private ReadManipulator mReadManipulator;
    private Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UIHelper.tranlucentTitle(this);
        window= getWindow();
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_read_book);
        readableFileUrl = getIntent().getParcelableExtra(FileChooseActivity.TEST_READABLE_FILE_URL);
         mReadManipulator = (ReadManipulator) findViewById(R.id.readmanipulator_read_book);
    }

}
