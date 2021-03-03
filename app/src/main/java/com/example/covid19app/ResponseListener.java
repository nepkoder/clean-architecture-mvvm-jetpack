package com.example.covid19app;

public interface ResponseListener<T> {

    void onStart();

    void onFinish();

    void onResponse(ApiResponse<T> apiResponse);

}
