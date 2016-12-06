package com.example.lixiang.rxjavatest.ui.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.lixiang.rxjavatest.R;
import com.example.lixiang.rxjavatest.data.JokeItemData;
import com.example.lixiang.rxjavatest.presenter.JokeItemPresenter;
import com.example.lixiang.rxjavatest.supprt.utils.CustomDialog;
import com.example.lixiang.rxjavatest.supprt.view.JokeItemView;
import com.example.lixiang.rxjavatest.ui.adapter.JokeItemAdapter;
import com.example.lixiang.rxjavatest.ui.adapter.baseadapter.OnItemClickListeners;
import com.example.lixiang.rxjavatest.ui.adapter.baseadapter.OnLoadMoreListener;
import com.example.lixiang.rxjavatest.ui.adapter.baseadapter.ViewHolder;

import java.util.ArrayList;

import butterknife.InjectView;


public class MainActivity extends BaseMvpActivity<JokeItemView, JokeItemPresenter> implements JokeItemView, SwipeRefreshLayout.OnRefreshListener,OnLoadMoreListener
        ,OnItemClickListeners<JokeItemData.ResultBean.DataBean>{
    private static final String TAG = "MainActivity";

    @InjectView(R.id.toolbar)
    Toolbar mToolbar;

    @InjectView(R.id.type_item_recyclerview)
    RecyclerView mRecyclerView;

    @InjectView(R.id.type_item_swipfreshlayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    CustomDialog mvpDialog;

    private JokeItemAdapter mJokeItemAdapter;

    private int PAGE_COUNT = 1;

    private int mTempPageCount = 2;

    private boolean isLoadMore;


    @Override
    protected JokeItemPresenter initPresenter() {
        return new JokeItemPresenter();
    }

    @Override
    protected void fetchData() {
        mPresenter.getJokeItemData(PAGE_COUNT);
    }

    @Override
    protected int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mToolbar.setTitle("笑话大全");
        setSupportActionBar(mToolbar);
        mvpDialog = new CustomDialog(mContext);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        //实现首次自动显示加载提示
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });

        //上拉加载
        mJokeItemAdapter = new JokeItemAdapter(this, new ArrayList<JokeItemData.ResultBean.DataBean>(), true);
        mJokeItemAdapter.setLoadingView(R.layout.load_loading_layout);
        mJokeItemAdapter.setOnLoadMoreListener(this);
        mJokeItemAdapter.setOnItemClickListener(this);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(mJokeItemAdapter);
        mvpDialog.show();

    }

    @Override
    protected void initData() {

    }


    @Override
    public void onSuccess(JokeItemData data) {
        mJokeItemAdapter.setData(data.getResult().getData());
        Log.d(TAG, data.toString());

        if (isLoadMore) {
            if (data.getResult().getData().size() == 0) {
                mJokeItemAdapter.setLoadEndView(R.layout.load_end_layout);
            } else {
                mJokeItemAdapter.setLoadMoreData(data.getResult().getData());
                mTempPageCount++;
            }
        } else {
            mJokeItemAdapter.setNewData(data.getResult().getData());
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onError(String error) {
        Log.d(TAG, error);
        if (isLoadMore) {
            mJokeItemAdapter.setLoadFailedView(R.layout.load_failed_layout);
        } else {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void hideLoading() {
        mvpDialog.dismiss();
    }

    @Override
    public void showLoading() {

    }


    @Override
    public void onRefresh() {
        isLoadMore = false;
        PAGE_COUNT = 1;
        fetchData();
    }


    @Override
    public void onLoadMore(boolean isReload) {
        if (PAGE_COUNT == mTempPageCount && !isReload) {
            return;
        }
        isLoadMore = true;
        PAGE_COUNT = mTempPageCount;
        fetchData();
    }

    @Override
    public void onItemClick(ViewHolder viewHolder, JokeItemData.ResultBean.DataBean data, int position) {

    }

}
