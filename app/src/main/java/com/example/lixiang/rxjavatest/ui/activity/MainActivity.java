package com.example.lixiang.rxjavatest.ui.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;

import com.example.lixiang.rxjavatest.R;
import com.example.lixiang.rxjavatest.data.JokeItemData;
import com.example.lixiang.rxjavatest.presenter.JokeItemPresenter;
import com.example.lixiang.rxjavatest.supprt.view.JokeItemView;
import com.example.lixiang.rxjavatest.ui.adapter.JokeItemAdapter;

public class MainActivity extends BaseMvpActivity<JokeItemView, JokeItemPresenter> implements JokeItemView, SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = "MainActivity";
    Toolbar mToolbar;

    private int PAGE_COUNT = 1;
    private String mSubtype;
    private int mTempPageCount = 2;

    private JokeItemAdapter mJokeItemAdapter;

    private boolean isLoadMore;//是否是底部加载更多

    ListView mListView;


    @Override
    protected JokeItemPresenter initPresenter() {
        return new JokeItemPresenter();
    }

    @Override
    protected void fetchData() {
        mPresenter.getJokeItemData(1, 20, "ac2773a5c0635ecb23c1b2eaa6c2bf9f");
    }

    @Override
    protected int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mListView = (ListView) findViewById(R.id.type_item_list);

        mToolbar.setTitle("笑话大全");
        setSupportActionBar(mToolbar);
    }

    @Override
    protected void initData() {
        mJokeItemAdapter = new JokeItemAdapter(getApplicationContext(), R.layout.joke_item_adapter);
        mListView.setAdapter(mJokeItemAdapter);
    }


    @Override
    public void onsuccess(JokeItemData data) {
        mJokeItemAdapter.addAll(data.getResult().getData());
        Log.d(TAG, data.toString());
    }

    @Override
    public void onError() {
        Log.d(TAG, "error");
    }

    @Override
    public void onRefresh() {
//        mSwipeRefreshLayout.setRefreshing(false);
    }
}
