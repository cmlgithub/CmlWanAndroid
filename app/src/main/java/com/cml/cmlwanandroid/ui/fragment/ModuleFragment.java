package com.cml.cmlwanandroid.ui.fragment;

import com.cml.cmlwanandroid.R;
import com.cml.cmlwanandroid.base.fragment.AbstractRootFragment;
import com.cml.cmlwanandroid.contract.ModuleContract;
import com.cml.cmlwanandroid.presenter.ModulePresenter;

/**
 * Created by chenmingliang on 2018/4/25.
 */

public class ModuleFragment extends AbstractRootFragment<ModulePresenter> implements ModuleContract.View {

    public static ModuleFragment getInstance(){
        ModuleFragment moduleFragment = new ModuleFragment();
        return moduleFragment;
    }

    @Override
    protected void initInject() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_module;
    }
}
