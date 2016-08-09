package com.daxing.epubtestdemo.util;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;

/**
 * Created by win7 on 2016/8/9.
 */

public class UIHelper {

    /**
     * 获取自定义的GradientDrawable
     * @param context
     * @param cornerRadius
     * @param colorRes
     * @param isSolid
     * @return
     */
    public static GradientDrawable getGradientDrawable(Context context, float cornerRadius, int colorRes, boolean isSolid) {
        return getGradientDrawableWithColorValue(context, cornerRadius, ContextCompat.getColor(context, colorRes), isSolid);
    }

    /**
     * 获取自定义的GradientDrawable
     * @param context
     * @param cornerRadius
     * @param colorValue
     * @param isSolid
     * @return
     */
    public static GradientDrawable getGradientDrawableWithColorValue(Context context, float cornerRadius, int colorValue, boolean isSolid) {
        GradientDrawable gd = new GradientDrawable();
        if (isSolid) {
            gd.setColor(colorValue);
        } else {
            gd.setColor(context.getResources().getColor(android.R.color.transparent));
            gd.setStroke(dip2px(context, 0.5f), colorValue);
        }
        gd.setCornerRadius(cornerRadius);
        return gd;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
