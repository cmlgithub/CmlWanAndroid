package com.cml.cmlwanandroid.ui;

import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.cml.cmlwanandroid.R;
import com.cml.cmlwanandroid.base.BaseActivity;
import com.cml.cmlwanandroid.contract.main.SplashContract;
import com.cml.cmlwanandroid.presenter.SplashPresenter;
import com.cml.cmlwanandroid.utils.StatusUtil;

import butterknife.BindView;

public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View{

    @BindView(R.id.oneAnimation)
    LottieAnimationView mOneAnimation;

    @Override
    public void initEventAndData() {
        StatusUtil.immersive(this);

        mOneAnimation.setAnimation("W.json");
        mOneAnimation.playAnimation();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void jumpToMain() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
    }
}
