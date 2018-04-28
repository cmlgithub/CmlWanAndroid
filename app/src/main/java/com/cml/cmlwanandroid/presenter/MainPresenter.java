package com.cml.cmlwanandroid.presenter;

import com.cml.cmlwanandroid.base.presenter.BasePresenter;
import com.cml.cmlwanandroid.contract.main.MainContract;

import javax.inject.Inject;

/**
 * Created by chenmingliang on 2018/4/24.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    @Inject
    public MainPresenter() {
    }

    @Override
    public void setNightModeState(boolean b) {

    }
}
