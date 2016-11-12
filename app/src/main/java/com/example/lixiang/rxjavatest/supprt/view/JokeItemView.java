package com.example.lixiang.rxjavatest.supprt.view;

import com.example.lixiang.rxjavatest.data.JokeItemData;


/**
 * Created by lixiang on 2016/11/12.
 */

public interface JokeItemView extends IBaseView {

    void onsuccess(JokeItemData data);
}
