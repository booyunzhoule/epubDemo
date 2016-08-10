package com.daxing.epubtestdemo.ui.util;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/**
 * Created by win7 on 2016/8/9.
 */

public class UICompatUtil {
    public static void setBackground(View view, Drawable drawable) {
        if (view == null || drawable == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }
}
