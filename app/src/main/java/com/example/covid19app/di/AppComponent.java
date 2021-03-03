package com.example.covid19app.di;

import android.app.Application;

import com.example.covid19app.CovidApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class,AppModule.class,ActivityModule.class,NetworkModule.class})
public interface AppComponent {

    void inject(CovidApp covidApp);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();

    }
}
