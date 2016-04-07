package com.rtfsc.rxjiandan.rest.executor;

import com.rtfsc.rxjiandan.model.Jokes;
import com.rtfsc.rxjiandan.rest.api.RequestJokes;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by kdroid on 16-4-6.
 */
public class JokesExecutor extends BaseExecutor<Jokes> {
    String mApi;
    String mPage;

    private JokesExecutor() {
    }

    public static final class Builder {
        String mBaseUrl = "http://jandan.net";
        String mApi = "jandan.get_duan_comments";
        String mPage = "1";

        public Builder setBaseUrl(String url) {
            mBaseUrl = url;
            return this;
        }

        public Builder setApi(String mApi) {
            this.mApi = mApi;
            return this;
        }

        public Builder setPage(String mPage) {
            this.mPage = mPage;
            return this;
        }

        public JokesExecutor build() {
            JokesExecutor executor = new JokesExecutor();
            executor.mApi = mApi;
            executor.mBaseUrl = mBaseUrl;
            executor.mPage = mPage;
            return executor;
        }
    }

    @Override
    public Observable<Jokes> get() {
        return getRetrofix().create(RequestJokes.class)
                .get(mApi, mPage)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
