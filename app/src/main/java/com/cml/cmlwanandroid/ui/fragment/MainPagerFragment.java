package com.cml.cmlwanandroid.ui.fragment;

import android.support.v4.app.Fragment;

import com.cml.cmlwanandroid.MainPagerBean;
import com.cml.cmlwanandroid.R;
import com.cml.cmlwanandroid.base.fragment.BaseFragment;
import com.cml.cmlwanandroid.contract.MainPagerContract;
import com.cml.cmlwanandroid.networkutil.CmlCallBackObserver;
import com.cml.cmlwanandroid.networkutil.NetWorkUtil;
import com.cml.cmlwanandroid.presenter.MainPagerPresenter;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chenmingliang on 2018/4/24.
 */

public class MainPagerFragment extends BaseFragment<MainPagerPresenter> implements MainPagerContract.View{

    private int curPage = 0;

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected void initEventAndData() {
        NetWorkUtil.getInterface()
                .getMainPagerData(curPage)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CmlCallBackObserver<MainPagerBean>() {
                    @Override
                    public void onSuccess(MainPagerBean mainPagerBean) {
                        List<MainPagerBean.DataBean.DatasBean> datas = mainPagerBean.data.datas;
                    }

                });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main_pager;
    }

    public static MainPagerFragment getInstance(){
        MainPagerFragment mainPagerFragment = new MainPagerFragment();
        return mainPagerFragment;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void getDataSuccess(MainPagerBean mainPagerBean) {

    }

    @Override
    public void getDataError(Throwable t) {

    }

    @Override
    public void dimissLoading() {

    }
}
