package com.example.lixiang.rxjavatest.ui.adapter;

import android.content.Context;

import com.example.lixiang.rxjavatest.R;
import com.example.lixiang.rxjavatest.data.JokeItemData;
import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;

import java.util.List;

/**
 * Created by lixiang on 2016/11/12.
 */

public class JokeItemAdapter extends QuickAdapter<JokeItemData.ResultBean.DataBean> {


    public JokeItemAdapter(Context context, int layoutResId) {
        super(context, layoutResId);
    }

    @Override
    protected void convert(BaseAdapterHelper helper, JokeItemData.ResultBean.DataBean item) {
        helper.setText(R.id.des, item.getContent());

    }
}
