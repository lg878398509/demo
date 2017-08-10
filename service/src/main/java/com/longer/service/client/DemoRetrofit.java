package com.longer.service.client;


import com.longer.service.client.core.ApiEndpoint;
import com.longer.service.client.core.BaseRetrofit;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

/**
 * Created by mingjun on 16/7/27.
 */
public class DemoRetrofit extends BaseRetrofit {

    private static final String END_POINT = "http://www.quanmin.tv/";

    DemoHttpClient mHttpClient;

    @Inject
    public DemoRetrofit(DemoHttpClient mHttpClient) {
        this.mHttpClient = mHttpClient;
    }

    @Override
    public ApiEndpoint getApiEndpoint() {
        return new ApiEndpoint() {
            @Override
            public String getEndpoint() {
                return END_POINT;
            }
        };
    }

    @Override
    public OkHttpClient getHttpClient() {
        return mHttpClient.get();
    }
}
