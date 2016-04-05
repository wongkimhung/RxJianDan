package com.rtfsc.rxjiandan.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.rtfsc.rxjiandan.R;
import com.rtfsc.rxjiandan.base.BaseFragment;
import com.rtfsc.rxjiandan.model.FreshNewsDetail;
import com.rtfsc.rxjiandan.model.Post;
import com.rtfsc.rxjiandan.rest.executor.FreshNewsDetailExecutor;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.functions.Action1;

/**
 * Created by kdroid on 16-4-5.
 */
public class FreshNewsDetailFragment extends BaseFragment {
    public static final String DATA_FRESH_NEWS = "DATA_FRESH_NEWS";
    private static final int SHOW_PAGE = 1;
    @Bind(R.id.webView)
    WebView mWebView;
    private Post mPost;

    public static FreshNewsDetailFragment getInstance(Post post) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(DATA_FRESH_NEWS, post);
        FreshNewsDetailFragment fragment = new FreshNewsDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_news_detail_item, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
        mPost = (Post) getArguments().getSerializable(DATA_FRESH_NEWS);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
               /* if (newProgress > 80) {
                    loading.stop();
                }*/
            }
        });
        if (mPost != null) {
            new FreshNewsDetailExecutor.Builder()
                    .setPostId(mPost.getId() + "")
                    .build()
                    .get()
                    .subscribe(new Action1<FreshNewsDetail>() {
                        @Override
                        public void call(FreshNewsDetail freshNewsDetail) {
                            mWebView.loadDataWithBaseURL("", getHtml(mPost, freshNewsDetail.getPost().getContent()), "text/html", "utf-8", "");
                        }
                    }, new Action1<Throwable>() {
                        @Override
                        public void call(Throwable throwable) {

                        }
                    });
        }
    }


    private static String getHtml(Post post, String content) {
        final StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>");
        sb.append("<html dir=\"ltr\" lang=\"zh\">");
        sb.append("<head>");
        sb.append("<meta name=\"viewport\" content=\"width=100%; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;\" />");
        sb.append("<link rel=\"stylesheet\" href='file:///android_asset/style.css' type=\"text/css\" media=\"screen\" />");
        sb.append("</head>");
        sb.append("<body style=\"padding:0px 8px 8px 8px;\">");
        sb.append("<div id=\"pagewrapper\">");
        sb.append("<div id=\"mainwrapper\" class=\"clearfix\">");
        sb.append("<div id=\"maincontent\">");
        sb.append("<div class=\"post\">");
        sb.append("<div class=\"posthit\">");
        sb.append("<div class=\"postinfo\">");
        sb.append("<h2 class=\"thetitle\">");
        sb.append("<a>");
        sb.append(post.getTitle());
        sb.append("</a>");
        sb.append("</h2>");
        sb.append(post.getAuthor().getName() + " @ ");
//        + String2TimeUtil
//                .dateString2GoodExperienceFormat(post.getDate())
        sb.append("</div>");
        sb.append("<div class=\"entry\">");
        sb.append(content);
        sb.append("</div>");
        sb.append("</div>");
        sb.append("</div>");
        sb.append("</div>");
        sb.append("</div>");
        sb.append("</div>");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }


    @Override
    public void onResume() {
        super.onResume();
        if (mWebView != null) {
            mWebView.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mWebView != null) {
            mWebView.onPause();
        }
    }
}
