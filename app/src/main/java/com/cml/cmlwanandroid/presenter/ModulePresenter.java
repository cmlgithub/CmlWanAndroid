package com.cml.cmlwanandroid.presenter;

import com.cml.cmlwanandroid.base.presenter.BasePresenter;
import com.cml.cmlwanandroid.contract.ModuleContract;

import javax.inject.Inject;

/**
 * Created by chenmingliang on 2018/4/25.
 */

public class ModulePresenter extends BasePresenter<ModuleContract.View> implements ModuleContract.Presenter  {

    @Inject
    public ModulePresenter(){}

}
