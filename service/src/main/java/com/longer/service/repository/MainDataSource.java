package com.longer.service.repository;

import android.app.Application;

import com.longer.service.api.MainApi;
import com.longer.service.response.ResponseResult;

import javax.inject.Inject;

import rx.Observable;

public class MainDataSource implements IMainService {


    @Inject
    Application mContext;

    MainApi maiApi;

    @Inject
    public MainDataSource(MainApi accountApi) {
        this.maiApi = accountApi;
    }

    @Override
    public Observable<ResponseResult> getLiveListResult() {

        return maiApi.getLiveListResult();
    }

}
