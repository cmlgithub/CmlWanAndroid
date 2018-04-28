package com.cml.cmlwanandroid.base.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cml.cmlwanandroid.R;
import com.cml.cmlwanandroid.utils.CommonUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by chenmingliang on 2018/4/24.
 */

public abstract class AbstractSimpleFragment extends SupportFragment{

    private Unbinder unbinder;
    private CompositeDisposable mCompositeDisposable;
    private boolean isInnerFragment;
    private long clickTime;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        unbinder = ButterKnife.bind(this, view);
        mCompositeDisposable = new CompositeDisposable();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mCompositeDisposable != null){
            mCompositeDisposable.clear();
        }
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //todo
    }

    @Override
    public boolean onBackPressedSupport() {
        if(getChildFragmentManager().getBackStackEntryCount() > 1){
            popChild();
        }else {
            if(isInnerFragment){
                _mActivity.finish();
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long time = 2000;
            if((currentTimeMillis - clickTime)>2000){
                CommonUtil.showSnackMessage(_mActivity,getString(R.string.double_click_exit_tint));
                clickTime = System.currentTimeMillis();
            }else {
                _mActivity.finish();
            }
        }
        return true;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initEventAndData();
    }

    protected abstract void initEventAndData();

    protected abstract int getLayoutId();
}
