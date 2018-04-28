package com.cml.cmlwanandroid.ui.fragment;

import com.cml.cmlwanandroid.R;
import com.cml.cmlwanandroid.base.fragment.AbstractRootFragment;
import com.cml.cmlwanandroid.contract.CollectContract;
import com.cml.cmlwanandroid.presenter.CollectPresenter;

/**
 * Created by chenmingliang on 2018/4/25.
 */

public class CollectFragment extends AbstractRootFragment<CollectPresenter> implements CollectContract.View {

    public static CollectFragment getInstance(){
        CollectFragment collectFragment = new CollectFragment();
        return collectFragment;
    }

    @Override
    protected void initInject() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_collect;
    }
}
