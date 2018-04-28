package com.cml.cmlwanandroid.networkutil;

import com.cml.cmlwanandroid.MainPagerBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by chenmingliang on 2018/4/28.
 */

public interface NetWorkInterface {


    @GET("article/list/{page}/json")
    Observable<MainPagerBean> getMainPagerData(@Path("page") int page);
}
