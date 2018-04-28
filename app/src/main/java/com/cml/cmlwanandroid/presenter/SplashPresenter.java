package com.cml.cmlwanandroid.presenter;

import com.cml.cmlwanandroid.base.presenter.AbstractPresenter;
import com.cml.cmlwanandroid.base.presenter.BasePresenter;
import com.cml.cmlwanandroid.contract.main.SplashContract;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

/**
 * Created by chenmingliang on 2018/4/19.
 */

public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter{

    @Inject
    public SplashPresenter(){

    }

    @Override
    public void attachView(final SplashContract.View view) {
        super.attachView(view);
        addSubscribe(Observable.timer(1000, TimeUnit.MILLISECONDS)
                                .subscribeOn(AndroidSchedulers.mainThread())
                                .subscribe(aLong -> view.jumpToMain()));
    }
}
