package com.cml.cmlwanandroid.utils;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.cml.cmlwanandroid.R;

/**
 * Created by chenmingliang on 2018/4/24.
 */

public class CommonUtil {

    public static void showSnackMessage(Activity activity,String msg){
        Snackbar snackbar = Snackbar.make(activity.getWindow().getDecorView(), msg, Snackbar.LENGTH_SHORT);
        View snackbarView = snackbar.getView();
        ((TextView)snackbarView.findViewById(R.id.snackbar_text)).setTextColor(ContextCompat.getColor(activity,android.R.color.white));
        snackbar.show();
    }

}
