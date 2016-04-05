package com.rtfsc.rxjiandan.rest.executor;

import com.rtfsc.rxjiandan.model.FreshNews;
import com.rtfsc.rxjiandan.rest.api.RequestFreshNews;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by kdroid on 16-3-30.
 */
public class FreshNewsExecutor extends BaseExecutor<FreshNews> {

    String mApi;
    String mInclude;
    String mFields;
    String mPage;
    String mDev;

    private FreshNewsExecutor() {
    }

    public static final class Builder {
        String mBaseUrl = "http://jandan.net";
        String mApi = "get_recent_posts";
        String mInclude = "url,date,tags,author,title,comment_count,custom_fields";
        String mFields = "thumb_c,views";
        String mDev = "1";
        String mPage = "1";

        public Builder setBaseUrl(String url) {
            mBaseUrl = url;
            return this;
        }

        public Builder setCustomfields(String custom_fields) {
            this.mFields = custom_fields;
            return this;
        }

        public Builder setInclude(String include) {
            this.mInclude = include;
            return this;
        }

        public Builder setApi(String mApi) {
            this.mApi = mApi;
            return this;
        }

        public void setDev(String dev) {
            this.mDev = dev;
        }

        public Builder setPage(String mPage) {
            this.mPage = mPage;
            return this;
        }

        public FreshNewsExecutor build() {
            FreshNewsExecutor adapter = new FreshNewsExecutor();
            adapter.mFields = mFields;
            adapter.mDev = mDev;
            adapter.mInclude = mInclude;
            adapter.mApi = mApi;
            adapter.mBaseUrl = mBaseUrl;
            adapter.mPage = mPage;
            return adapter;
        }
    }

    @Override
    public Observable<FreshNews> get() {
        return getRetrofix().create(RequestFreshNews.class)
                .get(mApi, mInclude, mFields, mDev, mPage)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());

    }
}
