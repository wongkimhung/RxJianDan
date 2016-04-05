package com.rtfsc.rxjiandan.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rtfsc.rxjiandan.R;
import com.rtfsc.rxjiandan.base.ConstantString;
import com.rtfsc.rxjiandan.callback.LoadResultCallBack;
import com.rtfsc.rxjiandan.model.FreshNews;
import com.rtfsc.rxjiandan.model.Post;
import com.rtfsc.rxjiandan.rest.executor.FreshNewsExecutor;
import com.rtfsc.rxjiandan.ui.activity.FreshNewsDetailActivity;
import com.rtfsc.rxjiandan.ui.fragment.FreshNewsFragment;
import com.rtfsc.rxjiandan.util.ShareUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.functions.Action1;

/**
 * Created by kdroid on 16-3-30.
 */
public class FreshNewsAdapter extends RecyclerView.Adapter<FreshNewsAdapter.ViewHolder> {
    private int page = 0;
    private int lastPosition = -1;
    private boolean isLargeMode;
    private Context mContext;
    private FreshNewsFragment mFragment;
    private FreshNews mFreshNews;

    public FreshNewsAdapter(FreshNewsFragment fragment, boolean isLargeMode) {
        this.mFragment = fragment;
        this.mContext = fragment.getActivity().getApplicationContext();
        this.isLargeMode = isLargeMode;
        int loadingResource = isLargeMode ? R.drawable.ic_loading_large : R.drawable.ic_loading_small;
    }

    /**
     * item 进入动画
     *
     * @param viewToAnimate
     * @param position
     */
    private void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext(), R
                    .anim.item_bottom_in);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public void onViewDetachedFromWindow(FreshNewsAdapter.ViewHolder holder) {
        if (isLargeMode) {
            holder.card.clearAnimation();
        } else {
            holder.ll_content.clearAnimation();
        }
    }

    @Override
    public FreshNewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId = isLargeMode ? R.layout.item_fresh_news : R.layout.item_fresh_news_small;
        View v = LayoutInflater.from(parent.getContext())
                .inflate(layoutId, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FreshNewsAdapter.ViewHolder holder, final int position) {
        final Post post = mFreshNews.getPosts().get(position);
        Glide.with(mContext).load(post.getCustom_fields().getThumb_c().get(0)).into(holder.img);
        holder.tv_title.setText(post.getTitle());
        holder.tv_info.setText(post.getAuthor().getName() + "@" + post.getTags().get(0).getTitle());

        if (isLargeMode) {

            holder.tv_share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShareUtil.shareText(mFragment.getActivity(), post.getTitle() + " " + post.getUrl());
                }
            });

            holder.card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    toDetailActivity(position);
                }
            });
            setAnimation(holder.card, position);
        } else {
            setAnimation(holder.ll_content, position);
        }

        if (position == mFreshNews.getPosts().size() - 1) {
            loadMore();
        }
    }

    private void toDetailActivity(int position) {
        Intent intent = new Intent(mFragment.getActivity(), FreshNewsDetailActivity.class);
        intent.putExtra(FreshNewsDetailActivity.DATA_FRESH_NEWS, mFreshNews);
        intent.putExtra(FreshNewsDetailActivity.DATA_POSITION, position);
        mFragment.getActivity().startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return mFreshNews == null ? 0 : mFreshNews.getPosts().size();
    }

    public void loadMore() {
        page++;
        loadDataByNetworkType();
    }

    private void loadDataByNetworkType() {

        /*if (NetWorkUtil.isNetWorkConnected(mActivity)) {*/
        new FreshNewsExecutor.Builder().setPage(page + "").build().get()
                .subscribe(new Action1<FreshNews>() {
                    @Override
                    public void call(FreshNews freshNews) {
                        mFragment.loadFinish(null);
                        if (page == 1) {
                            mFreshNews = freshNews;
                        } else {
                            mFreshNews.getPosts().addAll(freshNews.getPosts());
                        }
                        notifyDataSetChanged();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mFragment.onError(LoadResultCallBack.ERROR_NET, ConstantString.LOAD_FAILED);
                        throwable.printStackTrace();
                    }
                });
         /*}else {
            mLoadResultCallBack.onSuccess(LoadResultCallBack.SUCCESS_OK, null);
            mLoadFinisCallBack.loadFinish(null);

            if (page == 1) {
                mFreshNews.clear();
                ShowToast.Short(ConstantString.LOAD_NO_NETWORK);
            }

            mFreshNews.addAll(FreshNewsCache.getInstance(mActivity).getCacheByPage(page));
            notifyDataSetChanged();
        }*/

    }

    public void refresh() {
        page = 0;
        loadMore();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_title)
        TextView tv_title;
        @Bind(R.id.tv_info)
        TextView tv_info;
        @Bind(R.id.tv_views)
        TextView tv_views;
        @Nullable
        @Bind(R.id.tv_share)
        TextView tv_share;
        @Bind(R.id.img)
        ImageView img;
        @Nullable
        @Bind(R.id.card)
        CardView card;
        @Nullable
        @Bind(R.id.ll_content)
        LinearLayout ll_content;

        public ViewHolder(View contentView) {
            super(contentView);
            ButterKnife.bind(this, contentView);
        }
    }
}
