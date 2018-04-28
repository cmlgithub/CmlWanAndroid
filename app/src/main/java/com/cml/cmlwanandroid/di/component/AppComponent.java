package com.cml.cmlwanandroid.di.component;

import com.cml.cmlwanandroid.app.CmlWanAndroidApp;
import com.cml.cmlwanandroid.di.module.AppModule;
import com.cml.cmlwanandroid.di.module.HttpModule;
import com.cml.cmlwanandroid.di.scope.ActivityScope;
import com.cml.cmlwanandroid.ui.fragment.MainPagerFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by chenmingliang on 2018/4/18.
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

    CmlWanAndroidApp getContext();

}
