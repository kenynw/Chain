package com.dsk.chain.expansion.list;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.ViewGroup;

import com.dsk.chain.bijection.Presenter;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

import rx.Subscriber;

/**
 * Copyright (c) 2015. LiaoPeiKun Inc. All rights reserved.
 */
public class BaseListFragmentPresenter<V extends BaseListFragment, M> extends Presenter<V>
        implements SwipeRefreshLayout.OnRefreshListener, RecyclerArrayAdapter.OnLoadMoreListener {

    private DataAdapter mAdapter;

    private int mPage = 1;

    private Subscriber<List<M>> mRefreshSubscriber = new Subscriber<List<M>>() {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            getView().stopRefresh();
            getView().showError();
        }

        @Override
        public void onNext(List<M> beanList) {
            mAdapter.clear();
            mAdapter.addAll(beanList);
        }
    };

    private Subscriber<List<M>> mMoreSubscriber = new Subscriber<List<M>>() {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            mAdapter.pauseMore();
        }

        @Override
        public void onNext(List<M> list) {
            mAdapter.addAll(list);
            mPage++;
        }
    };

    DataAdapter createDataAdapter(){
        return mAdapter = new DataAdapter(getView().getActivity());
    }

    public DataAdapter getAdapter() {
        if (mAdapter == null) mAdapter = new DataAdapter(getView().getActivity());
        return mAdapter;
    }

    public Subscriber<List<M>> getRefreshSubscriber() {
        return mRefreshSubscriber;
    }

    public Subscriber<List<M>> getMoreSubscriber() {
        return mMoreSubscriber;
    }

    public int getCurPage() {
        return mPage;
    }

    public void setCurPage(int page) {
        mPage = page;
    }

    @Override
    public void onRefresh() {}

    @Override
    public void onLoadMore() {}

    public class DataAdapter extends RecyclerArrayAdapter<M> {

        public DataAdapter(Context context) {
            super(context);
        }

        @Override
        public int getViewType(int position) {
            return getView().getViewType(position);
        }

        @Override
        public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
            return getView().createViewHolder(parent, viewType);
        }

    }
}
