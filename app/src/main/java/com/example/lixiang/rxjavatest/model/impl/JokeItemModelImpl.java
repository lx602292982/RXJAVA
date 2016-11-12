package com.example.lixiang.rxjavatest.model.impl;

import com.example.lixiang.rxjavatest.Api.JokeItemService;
import com.example.lixiang.rxjavatest.data.JokeItemData;
import com.example.lixiang.rxjavatest.model.IJokeItemModel;
import com.example.lixiang.rxjavatest.net.NetManager;

import rx.Observable;

/**
 * Created by lixiang on 2016/11/12.
 */

public class JokeItemModelImpl implements IJokeItemModel {

    @Override
    public Observable<JokeItemData> getJokeData(int size, int pagesize, String key) {
        JokeItemService service = NetManager.getInstance().create(JokeItemService.class);
        return service.getJokeData(size, pagesize, key);
    }
}
