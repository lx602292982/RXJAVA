package com.example.lixiang.rxjavatest;

import android.app.Application;
import android.content.Context;

import com.example.lixiang.rxjavatest.supprt.utils.SPUtil;


/**
 * Author: Othershe
 * Time:  2016/8/11 10:37
 */
public class RxJavaApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();

        initRealm();
        SPUtil.init(mContext, "RxJava");
    }

    public static Context getContext() {
        return mContext;
    }

    private void initRealm() {
//        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).build();
//        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
