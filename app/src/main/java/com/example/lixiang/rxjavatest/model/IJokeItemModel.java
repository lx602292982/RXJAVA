package com.example.lixiang.rxjavatest.model;

import com.example.lixiang.rxjavatest.data.JokeItemData;

import rx.Observable;

/**
 * Created by lixiang on 2016/11/12.
 */

public interface IJokeItemModel {

    Observable<JokeItemData> getJokeData(int size,int pagesize, String key);
}
