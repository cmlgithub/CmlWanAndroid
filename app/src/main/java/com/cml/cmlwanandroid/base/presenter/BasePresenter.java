package com.cml.cmlwanandroid.base.presenter;

import com.cml.cmlwanandroid.base.view.BaseView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by chenmingliang on 2018/4/19.
 */

public class BasePresenter<T extends BaseView> implements AbstractPresenter<T> {

    public T mView;
    private CompositeDisposable compositeDisposable;

    public BasePresenter(){

    }

    protected void addSubscribe(Disposable disposable){
        if(compositeDisposable == null){
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        if(compositeDisposable != null){
            compositeDisposable.clear();
        }
    }
}
