package com.rtfsc.rxjiandan.rest.executor;

import com.rtfsc.rxjiandan.model.FreshNews;
import com.rtfsc.rxjiandan.model.FreshNewsDetail;
import com.rtfsc.rxjiandan.rest.api.RequestFreshNewsDetail;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by kdroid on 16-3-30.
 */
public class FreshNewsDetailExecutor extends BaseExecutor<FreshNewsDetail> {
    String mApi;
    String mInclude;
    String mPostId;


    public static final class Builder {
        //    String URL_FRESH_NEWS_DETAIL = "http://i.jandan.net/?oxwlxojflwblxbsapi=get_post&include=content";
        String mBaseUrl = "http://i.jandan.net";
        String mApi = "get_post";
        String mInclude = "content";
        String mPostId = "";

        public Builder setApi(String mApi) {
            this.mApi = mApi;
            return this;
        }

        public Builder setInclude(String include) {
            this.mInclude = include;
            return this;
        }

        public Builder setPostId(String mPostId) {
            this.mPostId = mPostId;
            return this;
        }

        public FreshNewsDetailExecutor build() {
            if (mPostId == null || mPostId.length() == 0) {
                throw new RuntimeException("your need set postId at least");
            }
            FreshNewsDetailExecutor adapter = new FreshNewsDetailExecutor();
            adapter.mBaseUrl = mBaseUrl;
            adapter.mApi = mApi;
            adapter.mPostId = mPostId;
            adapter.mInclude = mInclude;
            return adapter;
        }
    }

    @Override
    public Observable<FreshNewsDetail> get() {
        return getRetrofix().create(RequestFreshNewsDetail.class).get(mApi, mInclude, mPostId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
