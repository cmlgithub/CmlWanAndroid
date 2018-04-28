package com.cml.cmlwanandroid.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.FloatRange;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.cml.cmlwanandroid.BuildConfig;

/**
 * Created by chenmingliang on 2018/4/19.
 */

public class StatusUtil {

    private static final int DEFAULT_COLOR = 0;
    private static final int DEFAULT_ALPHA = 0;
    private static final int MIN_API = 14;
    private static final int L = 21;

    public static void immersive(Activity activity){
        immersive(activity,DEFAULT_COLOR,DEFAULT_ALPHA);
    }

    public static void immersive(Activity activity,int color,@FloatRange(from = 0.0, to = 1.0) float alpha){
        immersive(activity.getWindow(),color,alpha);
    }

    public static void immersive(Window window,int color,@FloatRange(from = 0.0, to = 1.0) float alpha){
        if(Build.VERSION.SDK_INT >= 21){
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(mixtureColor(color,alpha));
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }else if(Build.VERSION.SDK_INT >= 19){
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            setTranslucentView((ViewGroup)window.getDecorView(),color,alpha);
        }else if(Build.VERSION.SDK_INT > MIN_API && Build.VERSION.SDK_INT > 16){
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
            systemUiVisibility |= View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            systemUiVisibility |= View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            window.getDecorView().setSystemUiVisibility(systemUiVisibility);
        }
    }

    private static void setTranslucentView(ViewGroup container, int color, @FloatRange(from = 0.0, to = 1.0) float alpha) {
        if(Build.VERSION.SDK_INT >= 19){
            int mixtureColor = mixtureColor(color,alpha);
            View translucentView = container.findViewById(android.R.id.custom);
            if(translucentView == null && mixtureColor != 0){
                translucentView = new View(container.getContext());
                translucentView.setId(android.R.id.custom);
                ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(container.getContext()));
                container.setLayoutParams(lp);
            }

            if(translucentView != null){
                translucentView.setBackgroundColor(mixtureColor);
            }
        }
    }

    public static void setPaddingSmart(Context context,View view){
        if(Build.VERSION.SDK_INT >= L){
            ViewGroup.LayoutParams lp = view.getLayoutParams();
            if(lp != null && lp.height >= 0){
                lp.height += getStatusBarHeight(context);
            }

            view.setPadding(view.getPaddingLeft(),view.getPaddingTop()+getStatusBarHeight(context),
                    view.getPaddingRight(),view.getPaddingBottom());
        }
    }

    private static int getStatusBarHeight(Context context) {
        int result  = 24;
        int resId = context.getResources().getIdentifier("status_bar_height","dimen","android");
        if(resId > 0){
            result = context.getResources().getDimensionPixelSize(resId);
        }else {
            result = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,result, Resources.getSystem().getDisplayMetrics());
        }
        return result;
    }

    private static int mixtureColor(int color, @FloatRange(from = 0.0, to = 1.0) float alpha) {
        int a = (color & 0xff000000) == 0 ? 0xff : color >>> 24;
        return (color & 0x00ffffff) | (((int) (a * alpha)) << 24);
    }
}
