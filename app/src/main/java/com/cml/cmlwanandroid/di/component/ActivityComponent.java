package com.cml.cmlwanandroid.di.component;

import android.app.Activity;

import com.cml.cmlwanandroid.ui.MainActivity;
import com.cml.cmlwanandroid.ui.SplashActivity;
import com.cml.cmlwanandroid.di.module.ActivityModule;
import com.cml.cmlwanandroid.di.scope.ActivityScope;

import dagger.Component;

/**
 * Created by chenmingliang on 2018/4/18.
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(SplashActivity splashActivity);

    void inject(MainActivity mainActivity);

}
