package com.cml.cmlwanandroid.contract;

import android.view.View;

import com.cml.cmlwanandroid.base.presenter.AbstractPresenter;
import com.cml.cmlwanandroid.base.presenter.BasePresenter;
import com.cml.cmlwanandroid.base.view.BaseView;

/**
 * Created by chenmingliang on 2018/4/25.
 */

public class KnowContract {

    public interface View extends BaseView{

    }

    public interface Presenter extends AbstractPresenter<View>{

    }
}
