package com.rtfsc.rxjiandan.rest.executor;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by kdroid on 16-3-30.
 */
public abstract class BaseExecutor<T> {
    protected String mBaseUrl;

    protected Retrofit getRetrofix() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit;
    }

    public abstract Observable<T> get();
}
