package com.cml.cmlwanandroid.contract;

import com.cml.cmlwanandroid.base.presenter.AbstractPresenter;
import com.cml.cmlwanandroid.base.view.BaseView;

/**
 * Created by chenmingliang on 2018/4/25.
 */

public class CollectContract {

    public interface View extends BaseView{

    }

    public interface Presenter extends AbstractPresenter<View>{

    }
}
