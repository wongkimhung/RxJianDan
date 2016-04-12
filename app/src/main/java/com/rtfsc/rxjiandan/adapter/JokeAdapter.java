package com.rtfsc.rxjiandan.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rtfsc.rxjiandan.R;
import com.rtfsc.rxjiandan.base.ConstantString;
import com.rtfsc.rxjiandan.callback.LoadMoreListener;
import com.rtfsc.rxjiandan.callback.LoadResultCallBack;
import com.rtfsc.rxjiandan.model.Jokes;
import com.rtfsc.rxjiandan.rest.executor.JokesExecutor;
import com.rtfsc.rxjiandan.ui.fragment.JokeFragment;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.functions.Action1;

/**
 * Created by kdroid on 16-4-6.
 */
public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.ViewHolder> implements LoadMoreListener {
    private int mPage = 0;
    private List<Jokes.Joke> mJokes;
    private Context mContext;
    private JokeFragment mFragment;

    public JokeAdapter(JokeFragment fragment) {
        this.mFragment = fragment;
        this.mContext = fragment.getActivity().getApplicationContext();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_joke, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Jokes.Joke joke = mJokes.get(position);
        holder.tv_author.setText(joke.getComment_author());
        holder.tv_content.setText(joke.getText_content());
        holder.tv_time.setText(joke.getComment_date());
        holder.tv_like.setText(joke.getVote_positive());
        holder.tv_unlike.setText(joke.getVote_negative());
    }

    @Override
    public int getItemCount() {
        return mJokes == null ? 0 : mJokes.size();
    }

    @Override
    public void loadMore() {
        mPage++;
        new JokesExecutor.Builder().setPage(mPage + "").build().get()
                .subscribe(new Action1<Jokes>() {
                    @Override
                    public void call(Jokes jokes) {
                        if (jokes == null || !"ok".equals(jokes.getStatus()) || jokes.getComments() == null) {
                            return;
                        }

                        if (mJokes == null) {
                            mJokes = jokes.getComments();
                        } else {
                            mJokes.addAll(jokes.getComments());
                        }
                        notifyDataSetChanged();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mFragment.onError(LoadResultCallBack.ERROR_NET, ConstantString.LOAD_FAILED);
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
        @Bind(R.id.img_share)
        ImageView img_share;
        @Bind(R.id.card)
        CardView card;
        @Bind(R.id.ll_comment)
        LinearLayout ll_comment;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
