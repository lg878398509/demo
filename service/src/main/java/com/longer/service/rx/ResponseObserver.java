package com.longer.service.rx;

import rx.Subscriber;

/**
 * Created by longer on 2017/7/30.
 */
public abstract class ResponseObserver<T> extends Subscriber<T> {
    @Override
    public void onCompleted() {
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    public abstract void onSuccess(T t);
}
