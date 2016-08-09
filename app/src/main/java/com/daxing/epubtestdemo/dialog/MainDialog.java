package com.daxing.epubtestdemo.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daxing.epubtestdemo.R;
import com.daxing.epubtestdemo.dialog.base.BaseDialogFrag;

/**
 * Created by win7 on 2016/8/9.
 */

public class MainDialog extends BaseDialogFrag {

    @Override
    public Dialog onCreateDialog(FragmentActivity activity, Bundle savedInstanceState) {
        Log.i("TEST", "菜单chuanjian");
        View view = LayoutInflater.from(activity).inflate(R.layout.dialog_main,null);
        Log.i("TEST", "菜单buju");
        Dialog dialog = buildDefaultDialog(activity,view);
        dialog.setCanceledOnTouchOutside(true);
        return buildBottomInDialog(dialog);
    }

    @Override
    public int getWindowHeight() {
        return ViewGroup.LayoutParams.WRAP_CONTENT;
    }
}
