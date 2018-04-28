package com.cml.cmlwanandroid.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by chenmingliang on 2018/4/18.
 */

@Scope
@Retention(RUNTIME)
public @interface ActivityScope {
}
