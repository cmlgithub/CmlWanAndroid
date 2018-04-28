package com.cml.cmlwanandroid.base;

import com.cml.cmlwanandroid.app.CmlWanAndroidApp;
import com.cml.cmlwanandroid.base.presenter.AbstractPresenter;
import com.cml.cmlwanandroid.base.view.BaseView;
import com.cml.cmlwanandroid.di.component.ActivityComponent;
import com.cml.cmlwanandroid.di.component.DaggerActivityComponent;
import com.cml.cmlwanandroid.di.module.ActivityModule;

import javax.inject.Inject;

/**
 * Created by chenmingliang on 2018/4/18.
 */

public abstract class BaseActivity<T extends AbstractPresenter> extends AbstractSimpleActivity implements BaseView{

    @Inject
    protected T mPresenter;

    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        initInject();
        if(mPresenter != null)
            mPresenter.attachView(this);
    }

    protected ActivityComponent getActivityComponent(){
        return DaggerActivityComponent.builder()
                .appComponent(CmlWanAndroidApp.getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }



    protected abstract void initInject();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter != null)
            mPresenter.detachView();
    }
}
