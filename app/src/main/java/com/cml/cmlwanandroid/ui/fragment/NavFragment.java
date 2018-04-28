package com.cml.cmlwanandroid.ui.fragment;

import com.cml.cmlwanandroid.R;
import com.cml.cmlwanandroid.base.fragment.AbstractRootFragment;
import com.cml.cmlwanandroid.contract.NavContract;
import com.cml.cmlwanandroid.presenter.NavPresenter;

/**
 * Created by chenmingliang on 2018/4/25.
 */

public class NavFragment extends AbstractRootFragment<NavPresenter> implements NavContract.View {


    public static NavFragment getInstance(){
        NavFragment navFragment = new NavFragment();
        return navFragment;
    }

    @Override
    protected void initInject() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_nav;
    }
}
