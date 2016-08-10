package com.daxing.epubtestdemo.ui.popmenu;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.MenuRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v7.widget.PopupMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;

import com.daxing.epubtestdemo.R;

/**
 * Created by win7 on 2016/8/10.
 */

public class DemoPopMenu extends PopupMenu {
    private ImageView menuImageView;

    public void setMenuImageView(ImageView menuImageView) {
        this.menuImageView = menuImageView;
    }

    public DemoPopMenu(@NonNull Context context, @NonNull View anchor) {
        super(context, anchor);
    }

    public DemoPopMenu(@NonNull Context context, @NonNull View anchor, int gravity) {
        super(context, anchor, gravity);
    }

    public DemoPopMenu(@NonNull Context context, @NonNull View anchor, int gravity, @AttrRes int popupStyleAttr, @StyleRes int popupStyleRes) {
        super(context, anchor, gravity, popupStyleAttr, popupStyleRes);
    }

    @Override
    public void show() {
        super.show();
        menuImageView.setImageResource(R.drawable.zjb_icon_menu_unfold);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        menuImageView.setImageResource(R.drawable.zjb_icon_menu_fold);
    }




}
