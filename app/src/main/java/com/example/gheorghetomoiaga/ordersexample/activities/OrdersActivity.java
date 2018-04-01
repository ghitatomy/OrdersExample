package com.example.gheorghetomoiaga.ordersexample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.gheorghetomoiaga.ordersexample.R;
import com.example.gheorghetomoiaga.ordersexample.models.Order;
import com.example.gheorghetomoiaga.ordersexample.presenters.OrdersPresenter;
import com.example.gheorghetomoiaga.ordersexample.views.OrdersView;

import java.util.List;


public class OrdersActivity extends AppCompatActivity implements OrdersView {
    private OrdersPresenter ordersPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        ordersPresenter = new OrdersPresenter(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ordersPresenter.dettachView();
        ordersPresenter = null;
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void getDataSuccess(List<Order> model) {

    }

    @Override
    public void getDataFail(String message) {

    }

    @Override
    public void moveToDetail(Intent intent) {

    }
}
