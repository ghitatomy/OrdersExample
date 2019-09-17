package com.example.gheorghetomoiaga.ordersexample.services;

import com.example.gheorghetomoiaga.ordersexample.models.Order;

import java.util.List;

import retrofit2.http.GET;
import io.reactivex.Observable;

public interface OrdersService {
    @GET("api/orders")
    Observable<List<Order>> getOrders();
}
