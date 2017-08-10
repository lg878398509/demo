package com.longer.service.client.core;


import com.longer.service.converter.ResponseConvertFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;


public abstract class BaseRetrofit {

    public Retrofit get() {
        Retrofit.Builder builder = new Retrofit.Builder();

        builder.baseUrl(getApiEndpoint().getEndpoint())
                .client(getHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(ResponseConvertFactory.create());

        return builder.build();
    }

    public abstract ApiEndpoint getApiEndpoint();
    public abstract OkHttpClient getHttpClient();

}
