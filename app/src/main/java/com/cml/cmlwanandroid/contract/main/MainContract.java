package com.cml.cmlwanandroid.contract.main;

import com.cml.cmlwanandroid.base.presenter.AbstractPresenter;
import com.cml.cmlwanandroid.base.view.BaseView;

/**
 * Created by chenmingliang on 2018/4/24.
 */

public class MainContract {

    public interface View extends BaseView {

    }

    public interface Presenter extends AbstractPresenter<View>{
        void setNightModeState(boolean b);
    }

}
