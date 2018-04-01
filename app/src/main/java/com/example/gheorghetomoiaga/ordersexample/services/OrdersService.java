package com.example.gheorghetomoiaga.ordersexample.services;

import com.example.gheorghetomoiaga.ordersexample.models.Order;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Header;
import rx.Observable;


public interface OrdersService {
    @GET("orders")
    Observable<List<Order>> getOrders(@Header("Authorization") String authorization);
}
