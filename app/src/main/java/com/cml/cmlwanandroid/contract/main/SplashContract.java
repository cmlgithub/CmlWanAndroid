package com.cml.cmlwanandroid.contract.main;

import com.cml.cmlwanandroid.base.presenter.AbstractPresenter;
import com.cml.cmlwanandroid.base.view.BaseView;

/**
 * Created by chenmingliang on 2018/4/18.
 */

public class SplashContract {

    public interface View extends BaseView{
        void jumpToMain();
    }

    public interface Presenter extends AbstractPresenter<View>{

    }

}
