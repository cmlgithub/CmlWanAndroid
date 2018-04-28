package com.cml.cmlwanandroid.ui.fragment;

import com.cml.cmlwanandroid.R;
import com.cml.cmlwanandroid.base.fragment.AbstractRootFragment;
import com.cml.cmlwanandroid.base.presenter.AbstractPresenter;
import com.cml.cmlwanandroid.contract.KnowContract;
import com.cml.cmlwanandroid.presenter.KnowPresenter;

/**
 * Created by chenmingliang on 2018/4/25.
 */

public class KnowFragment extends AbstractRootFragment<KnowPresenter> implements KnowContract.View {

    public static KnowFragment getInstance(){
        KnowFragment knowFragment = new KnowFragment();
        return knowFragment;
    }

    @Override
    protected void initInject() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_know;
    }
}
