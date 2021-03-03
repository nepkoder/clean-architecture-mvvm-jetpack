package com.example.covid19app.di;

import android.app.Application;
import android.content.Context;

import com.example.covid19app.Api;
import com.example.covid19app.BaseScheduler;
import com.example.covid19app.DataManager;
import com.example.covid19app.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = {ViewModelModule.class})
public class AppModule {
    @Singleton
    @Provides
    Context getContext(Application application) {
        return application;
    }

    @Singleton
    @Provides
    BaseScheduler providesScheduler() {
        return new SchedulerProvider();
    }

    @Singleton
    @Provides
    Api providesApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

    @Singleton
    @Provides
    DataManager providesDataManager(Api api,BaseScheduler scheduler) {
        return new DataManager(api,scheduler);
    }
}
