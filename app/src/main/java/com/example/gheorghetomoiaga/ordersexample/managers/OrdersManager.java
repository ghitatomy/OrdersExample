package com.example.gheorghetomoiaga.ordersexample.managers;

import com.example.gheorghetomoiaga.ordersexample.api.ApiClient;
import com.example.gheorghetomoiaga.ordersexample.models.Order;
import com.example.gheorghetomoiaga.ordersexample.presenters.OrdersPresenter;
import com.example.gheorghetomoiaga.ordersexample.services.OrdersService;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class OrdersManager {
    private static final String AUTHORIZATION ="gNbptNL8Qw";
    private OrdersService orderService = ApiClient.getOrderApiClient().create(OrdersService.class);
    private OrdersPresenter ordersPresenter;

    public OrdersManager(OrdersPresenter ordersPresenter){
        this.ordersPresenter = ordersPresenter;
    }
    public void getOrders(){
        Observable<List<Order>> orderObserver = orderService.getOrders(AUTHORIZATION);

        orderObserver.subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Order>>() {
                    @Override
                    public void onCompleted() {
                        ordersPresenter.stopLoading();
                    }

                    @Override
                    public void onError(Throwable e) {
                        ordersPresenter.receiveOrdersFailed(e.getMessage());
                        ordersPresenter.stopLoading();
                    }

                    @Override
                    public void onNext(List<Order> orders) {
                        ordersPresenter.receiveOrdersSucces(orders);
                        ordersPresenter.stopLoading();
                    }
                });

    }
}
