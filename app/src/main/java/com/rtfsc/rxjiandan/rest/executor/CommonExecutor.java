package com.rtfsc.rxjiandan.rest.executor;

import com.rtfsc.rxjiandan.rest.api.RequestCommon;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by kdroid on 16-4-5.
 */
public class CommonExecutor {
    String mBaseUrl;

    public CommonExecutor(String url) {
        this.mBaseUrl = url;
    }

    public Observable<Response> get() {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(RequestCommon.class)
                .get()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
