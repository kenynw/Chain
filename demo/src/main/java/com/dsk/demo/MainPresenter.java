package com.dsk.demo;

import com.dsk.chain.expansion.list.BaseListActivityPresenter;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

/**
 * Created by LPK on 2016/11/12.
 */

public class MainPresenter extends BaseListActivityPresenter<MainActivity, User> {

    @Override
    protected void onCreateView(MainActivity view) {
        super.onCreateView(view);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        List<User> list = new ArrayList<>();
        for (int i=0; i<10; i++) {
            User user = new User();
            user.setName("sanmao" + i);
            user.setAge("18");
            list.add(user);
        }

        Observable.just(list).unsafeSubscribe(getRefreshSubscriber());
    }
}
