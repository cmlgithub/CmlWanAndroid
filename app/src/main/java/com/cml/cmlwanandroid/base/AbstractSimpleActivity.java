package com.cml.cmlwanandroid.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.cml.cmlwanandroid.component.ActivityCollector;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by chenmingliang on 2018/4/18.
 */

public abstract class AbstractSimpleActivity extends SupportActivity {


    private Unbinder unbinder;
    protected AbstractSimpleActivity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unbinder = ButterKnife.bind(this);
        mActivity = this;
        onViewCreated();
        ActivityCollector.getInstance().addActivity(this);
        initEventAndData();
    }

    public abstract void initEventAndData();

    protected abstract int getLayoutId();

    protected void onViewCreated() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.getInstance().removeActivity(this);
        unbinder.unbind();
    }
}
