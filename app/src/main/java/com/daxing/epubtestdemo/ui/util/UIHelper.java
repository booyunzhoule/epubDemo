package com.daxing.epubtestdemo.ui.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.daxing.epubtestdemo.ui.view.EpubNavigator;

/**
 * Created by win7 on 2016/8/9.
 */

public class UIHelper {

    private static long sLastClickTime; // 记录上次点击的毫秒值
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

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(EpubNavigator context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static void tranlucentTitle(Activity activity){
        Window window = activity.getWindow();
//		//     SDK > 5.0时状态栏透明化, 在部分手机上无效果
//		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS );
//			window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//			window.setStatusBarColor(Color.TRANSPARENT);
//		}

        //        SDK > 4.4时状态栏透明化
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT ) {
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    public static void measureLay(View lay) {
        int mW = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int mH = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        lay.measure(mW, mH);
    }

    public static void setNoFastClickListener(View view, View.OnClickListener listener) {
        setNoFastClickListener(view, 500, listener);
    }

    public static void setNoFastClickListener(View view, final int intervalTime, final View.OnClickListener listener) {
        if (view == null || listener == null) return;
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                long nowTime = System.currentTimeMillis();
//				ZJBLog.d("clickNowTime = %s, clickLastTime = %s, distanceTime = %s", nowTime, sLastClickTime, nowTime - sLastClickTime);
                if (nowTime > sLastClickTime + intervalTime || nowTime <= sLastClickTime) {
                    listener.onClick(v);
                }
                sLastClickTime = nowTime;
            }
        });
    }
}
