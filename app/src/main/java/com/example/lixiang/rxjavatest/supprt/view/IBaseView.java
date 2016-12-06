package com.example.lixiang.rxjavatest.supprt.view;

/**
 * Author: Othershe
 * Time:  2016/8/11 11:24
 */
public interface IBaseView {
    void onError(String error);

    void hideLoading();

    void showLoading();
}
