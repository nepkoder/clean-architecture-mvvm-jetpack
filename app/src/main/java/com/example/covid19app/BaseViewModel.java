package com.example.covid19app;

import androidx.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {
    private final DataManager dataManager;

    public BaseViewModel(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
