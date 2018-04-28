package com.cml.cmlwanandroid.contract;

import com.cml.cmlwanandroid.MainPagerBean;
import com.cml.cmlwanandroid.base.presenter.AbstractPresenter;
import com.cml.cmlwanandroid.base.view.BaseView;

/**
 * Created by chenmingliang on 2018/4/24.
 */

public class MainPagerContract {

    public interface View extends BaseView{
        void showLoading();
        void getDataSuccess(MainPagerBean mainPagerBean);
        void getDataError(Throwable t);
        void dimissLoading();
    }

    public interface Presenter extends AbstractPresenter<View>{
        void getMainPagerData(int curPage);
    }
}
