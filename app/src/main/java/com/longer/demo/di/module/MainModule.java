package com.longer.demo.di.module;


import com.longer.service.repository.IMainService;
import com.longer.service.repository.MainDataSource;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    public IMainService provideMainService(MainDataSource dataSource) {
        return dataSource;
    }

}
