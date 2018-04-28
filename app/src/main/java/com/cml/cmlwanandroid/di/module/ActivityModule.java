package com.cml.cmlwanandroid.di.module;

import android.app.Activity;

import com.cml.cmlwanandroid.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by chenmingliang on 2018/4/18.
 */
@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity){
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    Activity provideActivity(){
        return mActivity;
    }

}
