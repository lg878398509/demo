package com.longer.demo.base;

import android.app.Activity;
import android.os.Bundle;

import com.longer.demo.Application;
import com.longer.demo.di.component.ActivityComponent;
import com.longer.demo.di.component.DaggerActivityComponent;
import com.longer.demo.di.module.ActivityModule;

/**
 * Created by longer on 2017/7/30.
 */

public class BaseAcitvity extends Activity {
    private ActivityComponent mActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(Application.get(this).getComponent())
                    .build();
        }
        return mActivityComponent;
    }
}
