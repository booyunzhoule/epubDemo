package com.daxing.epubtestdemo.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.daxing.epubtestdemo.R;
import com.daxing.epubtestdemo.model.ReadableFile;
import com.daxing.epubtestdemo.ui.util.UIHelper;
import com.daxing.epubtestdemo.ui.view.EpubNavigator;


/**
 * Created by win7 on 2016/8/9.
 */
public class ReadBookActivity extends FragmentActivity {
    static float windowWidth = 720;//TODO TEST 获取屏幕大小
    private String readableFileUrl;
//    private Toolbar toolbar;
    private EpubNavigator mEpubNavigator;
    private Window window;
    private ReadableFile readableFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UIHelper.tranlucentTitle(this);
        window= getWindow();
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题栏
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_read_book);
        readableFileUrl = getIntent().getParcelableExtra(FileChooseActivity.TEST_READABLE_FILE_URL);
        readableFile = getIntent().getParcelableExtra("TEST_READABLE_FILE");
         mEpubNavigator = (EpubNavigator) findViewById(R.id.readmanipulator_read_book);

    }

}
