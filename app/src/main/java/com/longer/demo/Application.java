package com.longer.demo;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

import com.longer.demo.di.component.ApplicationComponent;
import com.longer.demo.di.component.DaggerApplicationComponent;
import com.longer.demo.di.module.ApplicationModule;

import demo.longer.com.util.AppLog;

/**
 * Created by longer on 2017/8/6.
 */

public class Application extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();

        // init logger.
        AppLog.init();

//        InitializeService.start(this);
    }

    public static Application get(Context context) {
        return (Application) context.getApplicationContext();
    }

    ApplicationComponent mApplicationComponent;

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

}
