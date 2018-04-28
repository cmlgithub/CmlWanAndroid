package com.cml.cmlwanandroid.di.module;

import com.cml.cmlwanandroid.app.CmlWanAndroidApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by chenmingliang on 2018/4/18.
 */
@Module
public class AppModule {

    private final CmlWanAndroidApp cmlWanAndroidApp;

    public AppModule(CmlWanAndroidApp cmlWanAndroidApp){
        this.cmlWanAndroidApp = cmlWanAndroidApp;
    }


    @Provides
    @Singleton
    CmlWanAndroidApp provideApplicationContext(){
        return cmlWanAndroidApp;
    }
}
