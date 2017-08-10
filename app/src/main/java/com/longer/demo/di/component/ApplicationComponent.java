package com.longer.demo.di.component;

import android.app.Application;
import android.content.Context;

import com.longer.demo.di.module.ApplicationModule;
import com.longer.demo.di.scope.ApplicationContext;
import com.longer.service.api.MainApi;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by longer on 2017/7/30.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    @ApplicationContext
    Context context();

    Application application();

    MainApi accountAccountApi();
}
