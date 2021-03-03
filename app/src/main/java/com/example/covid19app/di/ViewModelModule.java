package com.example.covid19app.di;

import com.example.covid19app.MainActivityVM;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainActivityVM.class)
    abstract MainActivityVM bindMainActivityVM(MainActivityVM mainActivityVM);
}
