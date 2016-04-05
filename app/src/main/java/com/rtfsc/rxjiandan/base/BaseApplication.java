package com.rtfsc.rxjiandan.base;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by kdroid on 16-3-31.
 */
public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
//        LeakCanary.install(this);
    }

}
