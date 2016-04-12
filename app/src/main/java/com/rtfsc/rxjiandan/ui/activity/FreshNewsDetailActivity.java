package com.rtfsc.rxjiandan.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;

import com.rtfsc.rxjiandan.R;
import com.rtfsc.rxjiandan.adapter.FreshNewsDetailAdapter;
import com.rtfsc.rxjiandan.model.FreshNews;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by kdroid on 16-4-5.
 */
public class FreshNewsDetailActivity extends AppCompatActivity {
    public static final String DATA_FRESH_NEWS = "DATA_FRESH_NEWS";

    public static final String DATA_POSITION = "DATA_POSITION";
    @Bind(R.id.vp)
    ViewPager viewPager;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
//    @Bind(R.id.swipe)
//    SwipeRefreshLayout mSwipe;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        initView();
        initData();
    }

    private void initView() {
        ButterKnife.bind(this);
        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        /*mSwipe.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);*/
    }

    private void initData() {
        FreshNews freshNews = (FreshNews) getIntent().getSerializableExtra
                (DATA_FRESH_NEWS);
        int position = getIntent().getIntExtra(DATA_POSITION, 0);
        viewPager.setAdapter(new FreshNewsDetailAdapter(getSupportFragmentManager(), freshNews.getPosts()));
        viewPager.setCurrentItem(position);
        /*viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
                        mSwipe.setEnabled(false);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        mSwipe.setEnabled(true);
                        break;
                }
                return false;
            }
        });*/
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
