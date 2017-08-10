package com.longer.demo.di.component;


import com.longer.demo.di.module.MainModule;
import com.longer.demo.ui.MainActivity;
import com.longer.demo.di.module.ActivityModule;
import com.longer.demo.di.scope.PerActivity;

import dagger.Component;

/**
 * Created by mingjun on 16/7/7.
 */
@PerActivity
@Component(
        dependencies = ApplicationComponent.class,
        modules = {ActivityModule.class, MainModule.class})
public interface MainComponent extends ActivityComponent {

    void inject(MainActivity loginActivity);

}
