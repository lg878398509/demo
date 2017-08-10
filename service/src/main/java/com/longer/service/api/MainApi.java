package com.longer.service.api;

import com.longer.service.response.ResponseResult;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by longer on 2017/7/30.
 */

public interface MainApi {
    @GET("json/play/list.json?v=3.0.1&os=1&ver=4")
    Observable<ResponseResult> getLiveListResult();

}
