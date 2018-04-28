package com.cml.cmlwanandroid.ui.fragment;

import com.cml.cmlwanandroid.R;
import com.cml.cmlwanandroid.base.fragment.AbstractRootFragment;
import com.cml.cmlwanandroid.contract.SettingContract;
import com.cml.cmlwanandroid.presenter.SettingPresenter;

/**
 * Created by chenmingliang on 2018/4/25.
 */

public class SettingFragment extends AbstractRootFragment<SettingPresenter> implements SettingContract.View {

    public static SettingFragment getInstance(){
        SettingFragment settingFragment = new SettingFragment();
        return settingFragment;
    }

    @Override
    protected void initInject() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }
}
