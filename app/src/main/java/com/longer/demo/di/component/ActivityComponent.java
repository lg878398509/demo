package com.longer.demo.di.component;

import android.app.Activity;

import com.longer.demo.di.module.ActivityModule;
import com.longer.demo.di.scope.PerActivity;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity activity();
}
