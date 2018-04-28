package com.cml.cmlwanandroid.base.presenter;

import com.cml.cmlwanandroid.base.view.BaseView;

/**
 * Created by chenmingliang on 2018/4/18.
 */

public interface AbstractPresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();
}
