package com.example.covid19app;

import android.util.Log;
import android.util.MalformedJsonException;

import java.io.IOException;
import java.net.SocketTimeoutException;

import retrofit2.HttpException;

public class ApiResponse<T> {
    public final int status;
    public final T data;

    public String errorCode = "200";
    public String errorDescription = "Something went wrong";

    public ApiResponse(int status, T data, Throwable throwable) {
        this.status = status;
        this.data = data;
        if(throwable!=null){
            parseException(throwable);}
    }

    private void parseException(Throwable throwable) {
        if (throwable != null) {
            if (throwable instanceof SocketTimeoutException) {
                this.errorDescription = "Oooops! We couldn’t capture your request in time. Please try again.";
                this.errorCode = "No_internet";

            } else if (throwable instanceof MalformedJsonException) {
                this.errorDescription = "Oops! We hit an error. Try again later.";
                this.errorCode = "malformed_json";

            } else if (throwable instanceof IOException) {
                this.errorDescription = "Oh! You are not connected to a wifi or cellular data network. Please connect and try again";
                this.errorCode = "No_internet";
            } else if (throwable instanceof HttpException) {

                if (((HttpException) throwable).code() == 500) {
                    this.errorDescription = "Internal Server Error";
                    this.errorCode = String.valueOf(((HttpException) throwable).response().code());
                } else {
                    try {
                        Log.d("sdsm", "mkhdsk");
                        this.errorDescription = ((HttpException) throwable).response().errorBody().string();
                        Log.d("sdsm", errorDescription);
                        this.errorCode = String.valueOf(((HttpException) throwable).response().code());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

    }
}
