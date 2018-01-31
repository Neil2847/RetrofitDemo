package com.example.neil.rereofitdeom.util;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;


/**
 * Created by neil on 2018/1/25.
 */

public class MyApplication extends Application {

    // --------------------------------------------------------
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    // --------------------------------------------------------
//    public static Context getContext() {
//        return getContext();
//    }

    // --------------------------------------------------------
}
