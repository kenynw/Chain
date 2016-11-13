package com.dsk.demo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.ViewGroup;

import com.dsk.chain.bijection.RequiresPresenter;
import com.dsk.chain.expansion.list.BaseListActivity;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

@RequiresPresenter(MainPresenter.class)
public class MainActivity extends BaseListActivity<MainPresenter> {

    @Override
    protected BaseViewHolder createViewHolder(ViewGroup parent, int viewType) {
        return new MainViewHolder(parent);
    }

}
