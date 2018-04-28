package com.cml.cmlwanandroid.presenter;

import com.cml.cmlwanandroid.MainPagerBean;
import com.cml.cmlwanandroid.base.presenter.BasePresenter;
import com.cml.cmlwanandroid.contract.MainPagerContract;
import com.cml.cmlwanandroid.networkutil.CmlCallBackObserver;
import com.cml.cmlwanandroid.networkutil.NetWorkUtil;
import com.cml.cmlwanandroid.ui.fragment.MainPagerFragment;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chenmingliang on 2018/4/24.
 */

public class MainPagerPresenter extends BasePresenter<MainPagerContract.View> implements MainPagerContract.Presenter {

    @Inject
    public MainPagerPresenter() {

    }


    @Override
    public void getMainPagerData(int curPage) {

    }
}
