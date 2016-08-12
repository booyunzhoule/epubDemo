package com.daxing.epubtestdemo.ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.daxing.epubtestdemo.R;

/**
 * Created by win7 on 2016/8/12.
 */

public class CatalogAndLabelDialogFrag extends MenuBaseDialogFrag {
    @Override
    public Dialog onCreateDialog(FragmentActivity activity, Bundle savedInstanceState) {
        View view = LayoutInflater.from(activity).inflate(R.layout.dialog_catalog_and_label,null);


        Dialog dialog = buildDefaultDialog(activity,view);
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }
}
