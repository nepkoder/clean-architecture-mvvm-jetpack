package com.example.covid19app;

import com.example.covid19app.models.CovidResponseWrapper;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    @GET("covid19/casedistribution/json/")
    Observable<CovidResponseWrapper> getCovidData();
}
