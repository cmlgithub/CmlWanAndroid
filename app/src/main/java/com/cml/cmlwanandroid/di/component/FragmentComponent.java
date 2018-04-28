package com.cml.cmlwanandroid.di.component;

import android.app.Activity;

import com.cml.cmlwanandroid.di.module.FragmentModule;
import com.cml.cmlwanandroid.di.scope.FragmentScope;
import com.cml.cmlwanandroid.ui.fragment.MainPagerFragment;

import dagger.Component;

/**
 * Created by chenmingliang on 2018/4/24.
 */
@FragmentScope
@Component(dependencies = AppComponent.class,modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(MainPagerFragment mainPagerFragment);
}
