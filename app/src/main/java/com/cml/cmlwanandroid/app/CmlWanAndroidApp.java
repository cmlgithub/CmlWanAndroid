package com.cml.cmlwanandroid.app;

import android.app.Application;

import com.cml.cmlwanandroid.di.component.AppComponent;
import com.cml.cmlwanandroid.di.component.DaggerAppComponent;
import com.cml.cmlwanandroid.di.module.AppModule;
import com.cml.cmlwanandroid.di.module.HttpModule;

/**
 * Created by chenmingliang on 2018/4/18.
 */

public class CmlWanAndroidApp extends Application {

    private static CmlWanAndroidApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static synchronized AppComponent getAppComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .httpModule(new HttpModule())
                .build();
    }
}
