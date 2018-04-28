package com.cml.cmlwanandroid.presenter;

import com.cml.cmlwanandroid.base.presenter.AbstractPresenter;
import com.cml.cmlwanandroid.base.presenter.BasePresenter;
import com.cml.cmlwanandroid.contract.NavContract;

import javax.inject.Inject;

/**
 * Created by chenmingliang on 2018/4/25.
 */

public class NavPresenter extends BasePresenter<NavContract.View> implements NavContract.Presenter {

    @Inject
    public NavPresenter(){}

}
