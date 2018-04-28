package com.cml.cmlwanandroid.networkutil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by chenmingliang on 2018/4/28.
 */

public abstract class CmlCallBackObserver<T> implements Observer<T> {

    public abstract void onSuccess(T t);

    public void onFailuer(Throwable e){

    }

    public void onPre(){

    }

    public void onFinish(){

    }

    @Override
    public void onSubscribe(Disposable d) {
        onPre();
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        onFailuer(e);
    }

    @Override
    public void onComplete() {
        onFinish();
    }
}
