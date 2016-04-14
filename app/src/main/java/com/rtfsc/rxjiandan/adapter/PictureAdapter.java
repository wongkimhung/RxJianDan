package com.rtfsc.rxjiandan.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rtfsc.rxjiandan.R;
import com.rtfsc.rxjiandan.model.Comment4Pic;
import com.rtfsc.rxjiandan.model.Picture;
import com.rtfsc.rxjiandan.rest.executor.PicturesExecutor;
import com.rtfsc.rxjiandan.ui.fragment.PictureFragment;
import com.rtfsc.rxjiandan.ui.view.ShowMaxImageView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.functions.Action1;

/**
 * Created by rtfsc on 2016/4/13.
 */
public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder> {
    protected int mPage = 0;
    protected List<Picture> mPictures;
    protected Context mContext;
    protected PictureFragment mFragment;
    protected String mApi;

    public PictureAdapter(PictureFragment fragment,String api) {
        this.mFragment = fragment;
        this.mContext = fragment.getActivity().getApplicationContext();
        mApi = api;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_pic, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Picture picture = mPictures.get(position);
        holder.tv_author.setText(picture.getComment_author());
        holder.tv_time.setText(picture.getComment_date());
        holder.tv_content.setText("");
        holder.tv_like.setText("00 " + picture.getVote_positive());
        holder.tv_unlike.setText("XX " + picture.getVote_negative());
//用于恢复默认的文字
        holder.tv_like.setTypeface(Typeface.DEFAULT);
        holder.tv_like.setTextColor(mContext.getResources().getColor(R.color
                .secondary_text_default_material_light));
        holder.tv_support_des.setTextColor(mContext.getResources().getColor(R.color
                .secondary_text_default_material_light));

        holder.tv_unlike.setText(picture.getVote_negative());
        holder.tv_unlike.setTypeface(Typeface.DEFAULT);
        holder.tv_unlike.setTextColor(mContext.getResources().getColor(R.color
                .secondary_text_default_material_light));
        holder.tv_un_support_des.setTextColor(mContext.getResources().getColor(R.color
                .secondary_text_default_material_light));

        String picUrl = null;
        if (null != picture.getPics() && null != picture.getPics().get(0) && picture.getPics().get(0).startsWith("http")) {
            picUrl = picture.getPics().get(0);
            if (picUrl.endsWith(".gif")) {
                holder.img_gif.setVisibility(View.VISIBLE);
                //非WIFI网络情况下，GIF图只加载缩略图，详情页才加载真实图片
//                if (!isWifiConnected) {
                picUrl = picUrl.replace("mw600", "small").replace("mw1200", "small").replace
                        ("large", "small");
//                }
                holder.progress.setProgress(0);
                holder.progress.setVisibility(View.GONE);
//                holder.progress.setVisibility(View.VISIBLE);
//                holder.progress.setProgress((int) (current * 100f / total));
            } else {
                holder.img_gif.setVisibility(View.GONE);
            }
            Glide.with(mContext).load(picUrl).placeholder(R.drawable.ic_loading_large).into(holder.img);
        }

    }

    @Override
    public int getItemCount() {
        return mPictures == null ? 0 : mPictures.size();
    }

    public void loadMore() {
        mPage++;
        new PicturesExecutor.Builder()
                .setApi(mApi)
                .setPage(mPage + "")
                .build()
                .get()
                .subscribe(new Action1<Comment4Pic>() {
                    @Override
                    public void call(Comment4Pic comment4Pic) {
                        if (mPictures == null) {
                            if (comment4Pic.getComments() != null) {
                                mPictures = comment4Pic.getComments();
                            }
                        } else {
                            mPictures.addAll(comment4Pic.getComments());
                        }
                        notifyDataSetChanged();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_author)
        TextView tv_author;
        @Bind(R.id.tv_time)
        TextView tv_time;
        @Bind(R.id.tv_content)
        TextView tv_content;
        @Bind(R.id.tv_like)
        TextView tv_like;
        @Bind(R.id.tv_unlike)
        TextView tv_unlike;
        @Bind(R.id.tv_comment_count)
        TextView tv_comment_count;
        @Bind(R.id.tv_unsupport_des)
        TextView tv_un_support_des;
        @Bind(R.id.tv_support_des)
        TextView tv_support_des;
        @Bind(R.id.img_share)
        ImageView img_share;
        @Bind(R.id.img_gif)
        ImageView img_gif;
        @Bind(R.id.img)
        ShowMaxImageView img;

        @Bind(R.id.ll_comment)
        LinearLayout ll_comment;
        @Bind(R.id.progress)
        ProgressBar progress;
        @Bind(R.id.card)
        CardView card;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
