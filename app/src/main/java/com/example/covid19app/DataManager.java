package com.example.covid19app;

import com.example.covid19app.models.CovidResponseWrapper;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DataManager {
    final Api api;
    final BaseScheduler scheduler;

    @Inject
    public DataManager(Api api, BaseScheduler scheduler) {
        this.api = api;
        this.scheduler = scheduler;
    }

    private <T> void performRequest(Observable<T> observable,ResponseListener<T> responseListener) {
        observable.subscribeOn(scheduler.io())
                .observeOn(scheduler.ui())
                .subscribe(new Observer<T>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        responseListener.onStart();
                    }

                    @Override
                    public void onNext(T t) {
                        responseListener.onResponse(new ApiResponse<>(ResponseStatus.SUCCESS,t,null));
                    }

                    @Override
                    public void onError(Throwable e) {
                        responseListener.onResponse(new ApiResponse<>(ResponseStatus.ERROR,null,e));
                    }

                    @Override
                    public void onComplete() {
                        responseListener.onFinish();
                    }
                });
    }

    public void getCovidRecords(ResponseListener<CovidResponseWrapper> responseListener) {
        performRequest(api.getCovidData(),responseListener);
    }

}
