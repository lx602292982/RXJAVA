package com.example.lixiang.rxjavatest.ui.adapter;

import android.content.Context;

import com.example.lixiang.rxjavatest.R;
import com.example.lixiang.rxjavatest.data.JokeItemData;
import com.example.lixiang.rxjavatest.ui.adapter.baseadapter.BaseAdapter;
import com.example.lixiang.rxjavatest.ui.adapter.baseadapter.ViewHolder;
import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;

import java.util.List;

/**
 * Created by lixiang on 2016/11/12.
 */

public class JokeItemAdapter extends BaseAdapter<JokeItemData.ResultBean.DataBean> {


    public JokeItemAdapter(Context context, List<JokeItemData.ResultBean.DataBean> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, JokeItemData.ResultBean.DataBean data) {
        holder.setText(R.id.des, data.getContent());
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.joke_item_adapter;
    }
}
