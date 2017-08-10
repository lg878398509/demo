package com.longer.demo.presenter.base;

import android.support.annotation.UiThread;


public interface MvpPresenter<V> {


    @UiThread
    void attachView(V view);


    @UiThread
    void detachView();

}
