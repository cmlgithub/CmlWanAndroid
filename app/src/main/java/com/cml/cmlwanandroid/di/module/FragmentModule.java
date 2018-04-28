package com.cml.cmlwanandroid.di.module;

import android.app.Activity;
import android.app.DialogFragment;
import android.support.v4.app.Fragment;

import com.cml.cmlwanandroid.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by chenmingliang on 2018/4/24.
 */
@Module
public class FragmentModule {

    private Fragment fragment;
    private DialogFragment dialogFragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    public FragmentModule(DialogFragment dialogFragment){
        this.dialogFragment = dialogFragment;
    }

    @Provides
    @FragmentScope
    Activity provideActivty(){
        if(fragment == null){
            return dialogFragment.getActivity();
        }
        return fragment.getActivity();
    }


}
