package com.example.gheorghetomoiaga.ordersexample.views;

import android.content.Intent;

import com.example.gheorghetomoiaga.ordersexample.models.Order;

import java.util.List;


public interface OrdersView {
    void showLoading();

    void hideLoading();

    void getDataSuccess(List<Order> model);

    void getDataFail(String message);

    void moveToDetail(Intent intent);
}
