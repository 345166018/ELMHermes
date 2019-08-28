package com.hongx.hermestest2;

import android.app.Application;

import xiaofei.library.hermes.Hermes;

/**
 * @author: fuchenming
 * @create: 2019-08-28 13:26
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Hermes.init(this);
    }

}
