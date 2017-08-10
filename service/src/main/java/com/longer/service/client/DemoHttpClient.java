package com.longer.service.client;

import android.app.Application;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

/**
 * Created by mingjun on 16/7/20.
 */
public class DemoHttpClient extends CacheHttpClient {

    @Inject
    public Application application;

    @Inject
    public DemoHttpClient() {
    }

    @Override
    public OkHttpClient.Builder customize(OkHttpClient.Builder builder) {
        builder = super.customize(builder);
        return builder;
    }
}
