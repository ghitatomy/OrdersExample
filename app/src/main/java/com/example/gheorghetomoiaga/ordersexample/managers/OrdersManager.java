package com.example.gheorghetomoiaga.ordersexample.managers;

import android.annotation.SuppressLint;
import com.example.gheorghetomoiaga.ordersexample.api.ApiClient;
import com.example.gheorghetomoiaga.ordersexample.models.Order;
import com.example.gheorghetomoiaga.ordersexample.presenters.OrdersPresenter;
import com.example.gheorghetomoiaga.ordersexample.services.OrdersService;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class OrdersManager {
    private OrdersService orderService = ApiClient.getOrderApiClient().create(OrdersService.class);
    private OrdersPresenter ordersPresenter;

    public OrdersManager(OrdersPresenter ordersPresenter){
        this.ordersPresenter = ordersPresenter;
    }

    @SuppressLint("CheckResult")
    public void getOrders(){
        Observable<List<Order>> ordersObservable = orderService.getOrders();
        this.ordersPresenter.startLoading();
        ordersObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete(() -> this.ordersPresenter.stopLoading())
                .unsubscribeOn(Schedulers.io())
                .subscribe(
                        orders -> {
                            ordersPresenter.receiveOrdersSuccess(orders);
                            ordersPresenter.stopLoading();
                            },
                        throwable -> {
                            ordersPresenter.receiveOrdersFailed(throwable.getMessage());
                            ordersPresenter.stopLoading();
                        });

    }
}
