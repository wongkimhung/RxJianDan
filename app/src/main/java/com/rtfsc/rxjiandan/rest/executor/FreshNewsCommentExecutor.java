package com.rtfsc.rxjiandan.rest.executor;

import com.rtfsc.rxjiandan.model.Comment4FreshNews;
import com.rtfsc.rxjiandan.model.FreshNewsDetail;
import com.rtfsc.rxjiandan.rest.api.RequestFreshNewsComment;
import com.rtfsc.rxjiandan.rest.api.RequestFreshNewsDetail;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by kdroid on 16-3-30.
 */
public class FreshNewsCommentExecutor extends BaseExecutor<Comment4FreshNews> {
    String mApi;
    String mInclude;
    String mPostId;

    private FreshNewsCommentExecutor() {
    }

    public static final class Builder {
        //        http://jandan.net/?oxwlxojflwblxbsapi=get_post&include=comments&id=77370
        String mBaseUrl = "http://jandan.net";
        String mApi = "get_post";
        String mInclude = "comments";
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

        public FreshNewsCommentExecutor build() {
            if (mPostId == null || mPostId.length() == 0) {
                throw new RuntimeException("your need set postId at least");
            }
            FreshNewsCommentExecutor adapter = new FreshNewsCommentExecutor();
            adapter.mBaseUrl = mBaseUrl;
            adapter.mApi = mApi;
            adapter.mPostId = mPostId;
            adapter.mInclude = mInclude;
            return adapter;
        }
    }


    @Override
    public Observable<Comment4FreshNews> get() {
        return getRetrofix().create(RequestFreshNewsComment.class).get(mApi, mInclude, mPostId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
