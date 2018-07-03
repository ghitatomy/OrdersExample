package com.example.gheorghetomoiaga.ordersexample.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
    public static final String ORDERS_BASE_URL ="http://demo7858322.mockable.io/";
    public static Retrofit retrofitOrder = null;

    public static Retrofit getOrderApiClient() {
        if (retrofitOrder == null) {
            retrofitOrder = new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(ORDERS_BASE_URL + "/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitOrder;
    }
}
