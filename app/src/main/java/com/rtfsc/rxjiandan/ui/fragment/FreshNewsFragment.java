package com.rtfsc.rxjiandan.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rtfsc.rxjiandan.R;
import com.rtfsc.rxjiandan.adapter.FreshNewsAdapter;
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
 * Created by kdroid on 16-3-31.
 */
public class FreshNewsFragment extends BaseFragment implements LoadFinishCallBack, LoadMoreListener, LoadResultCallBack {

    FreshNewsAdapter adapter;
    @Bind(R.id.recyclerView)
    AutoLoadRecyclerView recyclerView;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    Toastor mToast;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_news, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });
        // TODO 大小图模式切换
        adapter = new FreshNewsAdapter(this, true);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLoadMoreListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setOnPauseListenerParams(false, true);
        recyclerView.setAdapter(adapter);
        mToast = new Toastor(getActivity().getApplicationContext());
        loadMore();
    }

    @Override
    public void loadFinish(Object o) {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void loadMore() {
        mSwipeRefreshLayout.setRefreshing(true);
        adapter.loadMore();
    }

    public void refresh() {
        mSwipeRefreshLayout.setRefreshing(true);
        adapter.refresh();
    }

    @Override
    public void onSuccess(int result, Object object) {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onError(int code, String msg) {
        mToast.showSingleLongToast(ConstantString.LOAD_FAILED);
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }
}
