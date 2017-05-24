package com.androidframework.androidtohtml5;

import android.app.Application;

/**
 * Created by Dean.Zhang on 2017/5/24.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        System.loadLibrary("native-lib");
    }
}
