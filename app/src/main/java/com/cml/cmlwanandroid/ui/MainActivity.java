package com.cml.cmlwanandroid.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cml.cmlwanandroid.R;
import com.cml.cmlwanandroid.app.Constants;
import com.cml.cmlwanandroid.base.AbstractSimpleActivity;
import com.cml.cmlwanandroid.base.BaseActivity;
import com.cml.cmlwanandroid.contract.main.MainContract;
import com.cml.cmlwanandroid.presenter.MainPresenter;
import com.cml.cmlwanandroid.ui.fragment.CollectFragment;
import com.cml.cmlwanandroid.ui.fragment.KnowFragment;
import com.cml.cmlwanandroid.ui.fragment.MainPagerFragment;
import com.cml.cmlwanandroid.ui.fragment.ModuleFragment;
import com.cml.cmlwanandroid.ui.fragment.NavFragment;
import com.cml.cmlwanandroid.ui.fragment.SettingFragment;
import com.cml.cmlwanandroid.utils.StatusUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View{

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.toolBar)
    Toolbar mToolbar;
    @BindView(R.id.toolbar_text)
    TextView mToolbarText;
    @BindView(R.id.nav_main_navigationView)
    NavigationView mNavigationView;
    @BindView(R.id.bottom_nav)
    BottomNavigationView mBottomNavigationView;
    @BindView(R.id.floatButton)
    FloatingActionButton mFloatingActionButton;

    private List<Fragment> mFragments;
    private MainPagerFragment mMainPagerFragment;
    private int mLastFgIndex;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //todo
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragments = new ArrayList<>();
        if(savedInstanceState == null){
            mPresenter.setNightModeState(false);
            mMainPagerFragment = MainPagerFragment.getInstance();
            mFragments.add(mMainPagerFragment);
            initData();
            init();
            switchFragment(Constants.TYPE_HOME);
        }else {
            //todo
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.action_usage:
                Toast.makeText(mActivity, "usage", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_search:
                Toast.makeText(mActivity, "search", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void switchFragment(int position) {
        if(position >= Constants.TYPE_COLLECT){
            mBottomNavigationView.setVisibility(View.INVISIBLE);
            mFloatingActionButton.setVisibility(View.INVISIBLE);
        }else {
            mBottomNavigationView.setVisibility(View.VISIBLE);
            mFloatingActionButton.setVisibility(View.VISIBLE);
        }



        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        Fragment targetFragment = mFragments.get(position);
        Fragment lastFragment = mFragments.get(mLastFgIndex);
        mLastFgIndex = position;
        fragmentTransaction.hide(lastFragment);
        if(!targetFragment.isAdded()){
            getSupportFragmentManager().beginTransaction().remove(targetFragment).commit();
            fragmentTransaction.add(R.id.fragment_group,targetFragment);
        }
        fragmentTransaction.show(targetFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void init() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_item:
                        switchFragment(Constants.TYPE_HOME);
                        break;
                    case R.id.know_item:
                        switchFragment(Constants.TYPE_KNOW);
                        break;
                    case R.id.nav_item:
                        switchFragment(Constants.TYPE_NAV);
                        break;
                    case R.id.module_item:
                        switchFragment(Constants.TYPE_MODULE);
                        break;
                }
                return true;
            }
        });
        initNavigationView();
    }

    private void initData() {
        mFragments.add(KnowFragment.getInstance());
        mFragments.add(NavFragment.getInstance());
        mFragments.add(ModuleFragment.getInstance());
        mFragments.add(CollectFragment.getInstance());
        mFragments.add(SettingFragment.getInstance());
    }

    @Override
    public void initEventAndData() {
        initToolBar();
    }

    private void initToolBar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowTitleEnabled(false);
        mToolbarText.setText(getString(R.string.homePage));
        mToolbar.setNavigationOnClickListener(v -> onBackPressedSupport());
    }

    private void initNavigationView() {
        drawerAnimation();
        setMenuItemClick();
    }

    private void setMenuItemClick() {
        Menu mNavigationViewMenu = mNavigationView.getMenu();
        MainOnMenuItemClickListener mainOnMenuItemClickListener = new MainOnMenuItemClickListener();
        mNavigationViewMenu.findItem(R.id.nav_item_wan_android).setOnMenuItemClickListener(mainOnMenuItemClickListener);
        mNavigationViewMenu.findItem(R.id.nav_item_my_collect).setOnMenuItemClickListener(mainOnMenuItemClickListener);
        mNavigationViewMenu.findItem(R.id.nav_item_setting).setOnMenuItemClickListener(mainOnMenuItemClickListener);
        mNavigationViewMenu.findItem(R.id.nav_item_about).setOnMenuItemClickListener(mainOnMenuItemClickListener);
    }

    @Override
    public void onBackPressedSupport() {
        if(getSupportFragmentManager().getBackStackEntryCount() > 1){
            pop();
        }else {
            ActivityCompat.finishAfterTransition(this);
        }
    }

    private void drawerAnimation() {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                //获取mDrawerLayout中的第一个子布局，也就是布局中的RelativeLayout
                //获取抽屉的view
                View mContent = mDrawerLayout.getChildAt(0);
                float scale = 1 - slideOffset;
                float endScale = 0.8f + scale * 0.2f;
                float startScale = 1 - 0.3f * scale;

                //设置左边菜单滑动后的占据屏幕大小
                drawerView.setScaleX(startScale);
                drawerView.setScaleY(startScale);
                //设置菜单透明度
                drawerView.setAlpha(0.6f + 0.4f * (1 - scale));

                //设置内容界面水平和垂直方向偏转量
                //在滑动时内容界面的宽度为 屏幕宽度减去菜单界面所占宽度
                mContent.setTranslationX(drawerView.getMeasuredWidth() * (1 - scale));
                //设置内容界面操作无效（比如有button就会点击无效）
                mContent.invalidate();
                //设置右边菜单滑动后的占据屏幕大小
                mContent.setScaleX(endScale);
                mContent.setScaleY(endScale);
            }
        };

        actionBarDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initInject() {
        getActivityComponent().inject(this);
    }

    class MainOnMenuItemClickListener implements MenuItem.OnMenuItemClickListener{

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.nav_item_wan_android:
                    switchFragment(Constants.TYPE_HOME);
                    break;
                case R.id.nav_item_my_collect:
                    switchFragment(Constants.TYPE_COLLECT);
                    break;
                case R.id.nav_item_setting:
                    switchFragment(Constants.TYPE_SETTING);
                    break;
                case R.id.nav_item_about:
                    AboutActivity.startMe(mActivity);
                    break;
            }
            mDrawerLayout.closeDrawers();
            return true;
        }
    }
}
