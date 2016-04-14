package com.rtfsc.rxjiandan.presenter;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.widget.Toast;

import com.rtfsc.rxjiandan.R;
import com.rtfsc.rxjiandan.ui.activity.MainActivity;
import com.rtfsc.rxjiandan.ui.fragment.BoringFragment;
import com.rtfsc.rxjiandan.ui.fragment.FreshNewsFragment;
import com.rtfsc.rxjiandan.ui.fragment.JokeFragment;
import com.rtfsc.rxjiandan.ui.fragment.PictureFragment;
import com.rtfsc.rxjiandan.ui.fragment.SisterFragment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kdroid on 16-4-7.
 */
public class MainPresenter implements NavigationView.OnNavigationItemSelectedListener {
    MainActivity mainActivity;
    FragmentManager mFragmentManager;
    Context mContext;
    Fragment mContentFragment;
    Map<String, Fragment> mFragments;

    public MainPresenter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        mFragmentManager = mainActivity.getSupportFragmentManager();
        mContext = mainActivity.getApplicationContext();
        mFragments = new HashMap<>();
        mContentFragment = new FreshNewsFragment();
        mFragmentManager.beginTransaction().add(R.id.frame_container, mContentFragment).commit();
        mFragments.put(FreshNewsFragment.class.getSimpleName(), mContentFragment);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment to;
        switch (item.getItemId()) {
            case R.id.nav_home:
                if (!mFragments.containsKey(FreshNewsFragment.class.getSimpleName())) {
                    to = new FreshNewsFragment();
                    mFragments.put(FreshNewsFragment.class.getSimpleName(), to);
                } else {
                    to = mFragments.get(FreshNewsFragment.class.getSimpleName());
                }
                switchFragment(mContentFragment, to);
                mContentFragment = to;
                break;
            case R.id.nav_messages:
                if (!mFragments.containsKey(JokeFragment.class.getSimpleName())) {
                    to = new JokeFragment();
                    mFragments.put(JokeFragment.class.getSimpleName(), to);
                } else {
                    to = mFragments.get(JokeFragment.class.getSimpleName());
                }
                switchFragment(mContentFragment, to);
                mContentFragment = to;
                break;
            case R.id.nav_friends:
                if (!mFragments.containsKey(BoringFragment.class.getSimpleName())) {
                    to = new BoringFragment();
                    mFragments.put(BoringFragment.class.getSimpleName(), to);
                } else {
                    to = mFragments.get(BoringFragment.class.getSimpleName());
                }
                switchFragment(mContentFragment, to);
                mContentFragment = to;
                break;
            case R.id.nav_discussion:
                if (!mFragments.containsKey(SisterFragment.class.getSimpleName())) {
                    to = new SisterFragment();
                    mFragments.put(SisterFragment.class.getSimpleName(), to);
                } else {
                    to = mFragments.get(SisterFragment.class.getSimpleName());
                }
                switchFragment(mContentFragment, to);
                mContentFragment = to;
                break;
        }
        mainActivity.closeDrawer();
        return true;
    }


    private void switchFragment(Fragment from, Fragment to) {
        if (from != to) {
            FragmentTransaction transaction = mFragmentManager.beginTransaction().setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
            if (!to.isAdded()) {
                transaction.hide(from).add(R.id.frame_container, to).commit();
            } else {
                transaction.hide(from).show(to).commit();
            }
        }
    }

}
