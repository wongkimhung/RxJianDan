package com.rtfsc.rxjiandan.rest.executor;

import com.rtfsc.rxjiandan.model.Comment4Pic;
import com.rtfsc.rxjiandan.rest.api.RequestPictures;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by rtfsc on 2016/4/13.
 */
public class PicturesExecutor extends BaseExecutor<Comment4Pic> {

    String mApi;
    String mPage;

    private PicturesExecutor() {
    }

    public static final class Builder {
        String mBaseUrl = "http://jandan.net";
        String mApi = API_BORING_PICTURE;
        String mPage = "1";
        public static final String API_BORING_PICTURE = "jandan.get_pic_comments";
        public static final String API_SISTER = "jandan.get_ooxx_comments";

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

        public PicturesExecutor build() {
            PicturesExecutor executor = new PicturesExecutor();
            executor.mApi = mApi;
            executor.mBaseUrl = mBaseUrl;
            executor.mPage = mPage;
            return executor;
        }
    }

    @Override
    public Observable<Comment4Pic> get() {
        return getRetrofix().create(RequestPictures.class)
                .get(mApi, mPage)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
