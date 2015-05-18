package com.aoeng.leakcanary.application;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by sczhang on 15/5/11.
 */
public class MyMpplication extends Application {
    private static RefWatcher mRefWatcher;


    @Override
    public void onCreate() {
        super.onCreate();
        mRefWatcher = LeakCanary.install(MyMpplication.this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        MyMpplication myMpplication = (MyMpplication) context.getApplicationContext();
        return myMpplication.mRefWatcher;
    }

}
