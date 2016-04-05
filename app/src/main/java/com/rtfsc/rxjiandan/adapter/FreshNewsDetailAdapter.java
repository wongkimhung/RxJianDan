package com.rtfsc.rxjiandan.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rtfsc.rxjiandan.model.Post;
import com.rtfsc.rxjiandan.ui.fragment.FreshNewsDetailFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kdroid on 16-4-5.
 */
public class FreshNewsDetailAdapter extends FragmentPagerAdapter {
    private List<Post> posts;

    public FreshNewsDetailAdapter(FragmentManager fm, List<Post> posts) {
        super(fm);
        this.posts = posts;
    }

    @Override
    public Fragment getItem(int position) {
        return FreshNewsDetailFragment.getInstance(posts.get(position));
    }

    @Override
    public int getCount() {
        return posts == null ? 0 : posts.size();
    }
}
