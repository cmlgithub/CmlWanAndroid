package com.cml.cmlwanandroid.base.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.cml.cmlwanandroid.R;
import com.cml.cmlwanandroid.base.presenter.BasePresenter;

/**
 * Created by chenmingliang on 2018/4/25.
 */

public abstract class AbstractRootFragment<T extends BasePresenter> extends BaseFragment<T> {

    private View mNormalView;
    private View loadingView;
    private View errorView;
    private TextView errorTextView;
    private LottieAnimationView mLottieAnimationView;

    @Override
    protected void initEventAndData() {
        if(getView() == null) return;

        mNormalView = getView().findViewById(R.id.normal_view);

        if(mNormalView == null){
            new RuntimeException("The subclass of RootActivity must contain a View named 'mNormalView'.");
        }

        if(!(mNormalView.getParent() instanceof ViewGroup)){
            new RuntimeException("mNormalView's ParentView should be a ViewGroup.");
        }

        ViewGroup parent = (ViewGroup) mNormalView.getParent();
        View.inflate(_mActivity,R.layout.loading_view,parent);
        View.inflate(_mActivity,R.layout.error_view,parent);
        loadingView = parent.findViewById(R.id.loading_viewGroup);
        errorView = parent.findViewById(R.id.error_viewGroup);
        errorTextView = (TextView) errorView.findViewById(R.id.errorTextView);
        errorTextView.setOnClickListener(v -> reload());
        mLottieAnimationView = (LottieAnimationView) loadingView.findViewById(R.id.loadAnimationView);
        mNormalView.setVisibility(View.VISIBLE);
        loadingView.setVisibility(View.GONE);
        errorView.setVisibility(View.GONE);
    }
}
