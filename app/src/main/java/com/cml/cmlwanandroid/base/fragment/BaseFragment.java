package com.cml.cmlwanandroid.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.cml.cmlwanandroid.app.CmlWanAndroidApp;
import com.cml.cmlwanandroid.base.presenter.AbstractPresenter;
import com.cml.cmlwanandroid.base.view.BaseView;
import com.cml.cmlwanandroid.di.component.DaggerFragmentComponent;
import com.cml.cmlwanandroid.di.component.FragmentComponent;
import com.cml.cmlwanandroid.di.module.FragmentModule;

import javax.inject.Inject;

/**
 * Created by chenmingliang on 2018/4/24.
 */

public abstract class BaseFragment<T extends AbstractPresenter> extends AbstractSimpleFragment implements BaseView {

    @Inject
    protected T mPresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initInject();
        if(mPresenter != null){
            mPresenter.attachView(this);
        }
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if(mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }

    public FragmentComponent getFragmentComponent(){
        return DaggerFragmentComponent.builder()
                .appComponent(CmlWanAndroidApp.getAppComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }


    protected abstract void initInject();

    public void reload(){}
}
