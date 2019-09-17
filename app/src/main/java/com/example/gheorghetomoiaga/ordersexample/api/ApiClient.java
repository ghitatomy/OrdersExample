package com.example.gheorghetomoiaga.ordersexample.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class ApiClient {
    private static final String SERVER_PORT = "8081";
    private static final String HOST = "IP HERE";
    private static final String BASE_URL = "http://" + HOST + ":" + SERVER_PORT +"/";
    private static Retrofit retrofitOrder = null;

    public static Retrofit getOrderApiClient() {
        if (retrofitOrder == null) {
            retrofitOrder = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }
        return retrofitOrder;
    }
}
