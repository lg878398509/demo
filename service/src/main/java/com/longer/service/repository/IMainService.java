package com.longer.service.repository;


import com.longer.service.response.ResponseResult;

import rx.Observable;

public interface IMainService {
    Observable<ResponseResult> getLiveListResult();
}
