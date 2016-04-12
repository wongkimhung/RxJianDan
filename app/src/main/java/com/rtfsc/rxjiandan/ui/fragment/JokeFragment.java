package com.rtfsc.rxjiandan.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rtfsc.rxjiandan.R;
import com.rtfsc.rxjiandan.adapter.JokeAdapter;
import com.rtfsc.rxjiandan.base.BaseFragment;
import com.rtfsc.rxjiandan.base.ConstantString;
import com.rtfsc.rxjiandan.callback.LoadFinishCallBack;
import com.rtfsc.rxjiandan.callback.LoadMoreListener;
import com.rtfsc.rxjiandan.callback.LoadResultCallBack;
import com.rtfsc.rxjiandan.ui.view.AutoLoadRecyclerView;
import com.rtfsc.rxjiandan.util.Toastor;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by kdroid on 16-4-6.
 */
public class JokeFragment extends BaseFragment implements LoadFinishCallBack, LoadMoreListener, LoadResultCallBack {
    @Bind(R.id.recyclerView)
    AutoLoadRecyclerView mRecyclerView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    JokeAdapter mAdapter;
    Toastor mToast;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_autoload_recycler, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setLoadMoreListener(this);
        mAdapter = new JokeAdapter(this);
        mRecyclerView.setAdapter(mAdapter);
        loadMore();
    }

    @Override
    public void loadFinish(Object o) {

    }

    @Override
    public void loadMore() {
        mAdapter.loadMore();
    }

    @Override
    public void onSuccess(int result, Object object) {

    }

    @Override
    public void onError(int code, String msg) {
        Toast.makeText(getActivity().getApplicationContext(),ConstantString.LOAD_FAILED,Toast.LENGTH_SHORT).show();
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }
}
