package com.example.gheorghetomoiaga.ordersexample.presenters;


import com.example.gheorghetomoiaga.ordersexample.managers.OrdersManager;
import com.example.gheorghetomoiaga.ordersexample.models.Order;
import com.example.gheorghetomoiaga.ordersexample.views.OrdersView;

import java.util.List;


public class OrdersPresenter {
    private OrdersView view;
    private OrdersManager ordersManager;

    public OrdersPresenter(OrdersView view){
        this.attachView(view);
        initManager();
        getOrders();
    }

    private void initManager(){
        ordersManager = new OrdersManager(this);
    }

    private void attachView(OrdersView view) {
        this.view = view;
    }

    public void dettachView() {
        this.view = null;
    }

    private void getOrders(){
        ordersManager.getOrders();
    }

    public void startLoading(){
        this.view.showLoading();
    }

    public void stopLoading(){
        this.view.hideLoading();
    }

    public void receiveOrdersSuccess(List<Order> orders) {
        this.view.getDataSuccess(orders);
    }

    public void receiveOrdersFailed(String errorMessage) {
        this.view.getDataFail(errorMessage);
    }
}
