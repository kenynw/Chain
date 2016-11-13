package com.dsk.demo;

import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Copyright (c) 2016/11/12. LiaoPeiKun Inc. All rights reserved.
 */

public class MainViewHolder extends BaseViewHolder<User> {

    @Bind(R.id.name)
    TextView mTvName;

    @Bind(R.id.age)
    TextView mTvAge;

    public MainViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_user_list);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(User data) {
        mTvName.setText(data.getName());
        mTvAge.setText(data.getAge());
    }
}
