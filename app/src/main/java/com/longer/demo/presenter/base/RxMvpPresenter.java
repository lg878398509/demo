package com.longer.demo.presenter.base;


import com.longer.demo.base.MvpView;

import rx.subscriptions.CompositeSubscription;

public class RxMvpPresenter<V extends MvpView> extends BaseMvpPresenter<V> {

    protected CompositeSubscription mCompositeSubscription;

    @Override
    public void attachView(V mvpView) {
        super.attachView(mvpView);

        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        super.detachView();

        mCompositeSubscription.clear();
        mCompositeSubscription = null;
    }
}
