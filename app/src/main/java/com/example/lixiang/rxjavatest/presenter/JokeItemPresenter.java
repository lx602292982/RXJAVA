package com.example.lixiang.rxjavatest.presenter;

import com.example.lixiang.rxjavatest.constant.Config;
import com.example.lixiang.rxjavatest.data.JokeItemData;
import com.example.lixiang.rxjavatest.model.IJokeItemModel;
import com.example.lixiang.rxjavatest.model.impl.JokeItemModelImpl;
import com.example.lixiang.rxjavatest.rx.RxManager;
import com.example.lixiang.rxjavatest.rx.RxSubscriber;
import com.example.lixiang.rxjavatest.supprt.view.JokeItemView;

/**
 * Created by lixiang on 2016/11/12.
 */

public class JokeItemPresenter extends BasePresenter<JokeItemView> {

    public IJokeItemModel mModel;

    public JokeItemPresenter() {
        mModel = new JokeItemModelImpl();
    }

    public void getJokeItemData(int size) {
        mSubscription = RxManager.getInstance().doSubscribe(mModel.getJokeData(size, Config.PAGE_SIZE, Config.JUhE_KEY), new RxSubscriber<JokeItemData>(true) {
            @Override
            public void onStart() {
                super.onStart();
                mView.showLoading();
            }

            @Override
            protected void _onNext(JokeItemData jokeItemData) {
                mView.hideLoading();
                mView.onSuccess(jokeItemData);
            }

            @Override
            protected void _onError() {
                mView.hideLoading();
                mView.onError("请求错误！");
            }
        });
    }
}
