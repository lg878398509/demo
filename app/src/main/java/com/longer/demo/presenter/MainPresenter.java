package com.longer.demo.presenter;

import android.app.Application;

import com.longer.demo.presenter.base.RxMvpPresenter;
import com.longer.demo.ui.view.MainView;
import com.longer.service.repository.IMainService;
import com.longer.service.response.ResponseResult;
import com.longer.service.rx.ResponseObserver;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;

/**
 * Created by longer on 2017/8/7.
 */

public class MainPresenter extends RxMvpPresenter<MainView> {

    private final IMainService mainService;


    @Inject
    public MainPresenter(IMainService mainService) {
        this.mainService = mainService;
    }

    @Inject
    Application context;

    public void getLiveListResult() {
        mCompositeSubscription.add(mainService.getLiveListResult()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        //加载中处理
                    }
                })
                .doOnTerminate(new Action0() {
                    @Override
                    public void call() {
                        //加载完成处理
                    }
                })
                .subscribe(new ResponseObserver<ResponseResult>() {
                    @Override
                    public void onSuccess(ResponseResult result) {

                        getMvpView().loginSuccess(result);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        getMvpView().loginException();
                    }
                }));
    }
}
