package com.cml.cmlwanandroid.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.cml.cmlwanandroid.R;
import com.cml.cmlwanandroid.base.AbstractSimpleActivity;
import com.cml.cmlwanandroid.utils.StatusUtil;
import com.cml.cmlwanandroid.widget.interpolator.ElasticOutInterpolator;
import com.scwang.smartrefresh.header.FlyRefreshHeader;
import com.scwang.smartrefresh.header.flyrefresh.FlyView;
import com.scwang.smartrefresh.header.flyrefresh.MountainSceneView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.scwang.smartrefresh.layout.util.DesignUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutActivity extends AbstractSimpleActivity {

    @BindView(R.id.about_toolbar)
    Toolbar mToolBar;
    @BindView(R.id.content_textView)
    TextView mContent;
    @BindView(R.id.version_textView)
    TextView mVersion;
    @BindView(R.id.about_refresh_header)
    FlyRefreshHeader mFlyRefreshHeader;
    @BindView(R.id.about_mountain)
    MountainSceneView mMountainSceneView;
    @BindView(R.id.about_us_fly_view)
    FlyView mFlyView;
    @BindView(R.id.about_refresh_layout)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.about_us_fab)
    FloatingActionButton mFab;
    @BindView(R.id.about_toolbar_layout)
    CollapsingToolbarLayout mToolbarLayout;
    @BindView(R.id.about_appBarLayout)
    AppBarLayout mAppBarLayout;
    @BindView(R.id.about_us_content)
    NestedScrollView mNestedScrollView;
    private View.OnClickListener mThemeListener;

    public static void startMe(Context context){
        context.startActivity(new Intent(context,AboutActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public void initEventAndData() {
        setSupportActionBar(mToolBar);
        StatusUtil.immersive(this);
        StatusUtil.setPaddingSmart(this,mToolBar);
        mToolBar.setNavigationOnClickListener(v -> onBackPressedSupport());

        mContent.setText(Html.fromHtml(getString(R.string.about_content)));
        mContent.setMovementMethod(LinkMovementMethod.getInstance());

        try {
            mVersion.setText("version: "+getPackageManager().getPackageInfo(getPackageName(),0).versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        mFlyRefreshHeader.setUp(mMountainSceneView,mFlyView);
        mSmartRefreshLayout.setReboundInterpolator(new ElasticOutInterpolator());
        mSmartRefreshLayout.setReboundDuration(800);
        mSmartRefreshLayout.setOnRefreshListener(refreshLayout -> {
            updateTheme();
            refreshLayout.finishRefresh(1000);
        });

        mSmartRefreshLayout.setOnMultiPurposeListener(new SimpleMultiPurposeListener(){
            @Override
            public void onHeaderPulling(RefreshHeader header, float percent, int offset, int headerHeight, int extendHeight) {
                if(mAppBarLayout == null || mToolBar == null) return;
                mAppBarLayout.setTranslationY(offset);
                mToolBar.setTranslationY(-offset);
            }

            @Override
            public void onHeaderReleasing(RefreshHeader header, float percent, int offset, int footerHeight, int extendHeight) {
                if(mAppBarLayout == null || mToolBar == null) return;
                mAppBarLayout.setTranslationY(offset);
                mToolBar.setTranslationY(-offset);
            }
        });

        mSmartRefreshLayout.autoRefresh();

        mFab.setOnClickListener(v -> mSmartRefreshLayout.autoRefresh());

        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {

            boolean misAppbarExpand = false;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                float fraction = 1f * (totalScrollRange + verticalOffset) / totalScrollRange;
                double minFraction = 0.1;
                double maxFraction = 0.8;
                if(fraction < minFraction && misAppbarExpand){
                    misAppbarExpand = false;
                    mFab.animate().scaleX(0).scaleY(0);
                    mFlyView.animate().scaleX(0).scaleY(0);
                    ValueAnimator animator = ValueAnimator.ofInt(mNestedScrollView.getPaddingTop(), 0);
                    animator.setDuration(300);
                    animator.addUpdateListener(animation -> mNestedScrollView.setPadding(0, (int) animation.getAnimatedValue(),0,0));
                    animator.start();
                }

                if(fraction > maxFraction && !misAppbarExpand){
                    misAppbarExpand = true;
                    mFab.animate().scaleX(1).scaleY(1);
                    mFlyView.animate().scaleX(1).scaleY(1);
                    ValueAnimator valueAnimator = ValueAnimator.ofInt(mNestedScrollView.getPaddingTop(), DensityUtil.dp2px(25));
                    valueAnimator.setDuration(300);
                    valueAnimator.addUpdateListener(animation -> mNestedScrollView.setPadding(0, (Integer) animation.getAnimatedValue(),0,0));
                    valueAnimator.start();
                }
            }
        });

    }

    private void updateTheme(){
        if(mThemeListener == null){
            mThemeListener = new View.OnClickListener() {

                int index = 0;
                int[] ids = new int[]{
                        R.color.colorPrimary,
                        android.R.color.holo_green_light,
                        android.R.color.holo_red_light,
                        android.R.color.holo_orange_light,
                        android.R.color.holo_blue_light
                };

                @Override
                public void onClick(View v) {
                    int color = ContextCompat.getColor(getApplication(), ids[index % ids.length]);
                    mSmartRefreshLayout.setPrimaryColors(color);
                    mFab.setBackgroundColor(color);
                    mFab.setBackgroundTintList(ColorStateList.valueOf(color));
                    mToolbarLayout.setContentScrimColor(color);
                    index++;
                }
            };
        }
        mThemeListener.onClick(null);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about;
    }

}
