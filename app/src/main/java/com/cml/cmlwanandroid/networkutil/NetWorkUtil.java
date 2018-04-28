package com.cml.cmlwanandroid.networkutil;

import com.cml.cmlwanandroid.app.Constants;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chenmingliang on 2018/4/28.
 */

public class NetWorkUtil<T> {

    private static Retrofit mRetrofit = null;

    private NetWorkUtil(){}


    private static Retrofit getRetrofit(){
        if(mRetrofit == null){
            synchronized (NetWorkUtil.class){
                if(mRetrofit == null){
                    mRetrofit = new Retrofit.Builder()
                            .client(getOkhttp())
                            .baseUrl(Constants.BASE_URL)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return mRetrofit;
    }

    public static NetWorkInterface getInterface(){
        return getRetrofit().create(NetWorkInterface.class);
    }




    private static OkHttpClient getOkhttp() {
        return new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {//拦截器 可用来添加请求头
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder builder = chain.request().newBuilder();
                        builder
                                .addHeader("isMerchants","1")
                                .addHeader("MobileSystem","Android");
                        return chain.proceed(builder.build());
                    }
                })
                .build();
    }

}
