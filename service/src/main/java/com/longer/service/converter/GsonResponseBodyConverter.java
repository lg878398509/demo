package com.longer.service.converter;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import demo.longer.com.util.AppLog;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by longer on 2017/7/30.
 */
public class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type type;

    GsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        AppLog.i("<<<<<<<<<<<<<<<<<<<<<<<<<<<< Network response >>>>>>>>>>>>>>>>>>>>>>" + response);
        return gson.fromJson(response, type);
    }
}


