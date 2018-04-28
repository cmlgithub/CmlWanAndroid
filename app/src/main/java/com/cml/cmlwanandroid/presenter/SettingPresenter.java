package com.cml.cmlwanandroid.presenter;

import com.cml.cmlwanandroid.base.presenter.BasePresenter;
import com.cml.cmlwanandroid.contract.SettingContract;

import javax.inject.Inject;

/**
 * Created by chenmingliang on 2018/4/25.
 */

public class SettingPresenter extends BasePresenter<SettingContract.View> implements SettingContract.Presenter {

    @Inject
    public SettingPresenter(){}

}
