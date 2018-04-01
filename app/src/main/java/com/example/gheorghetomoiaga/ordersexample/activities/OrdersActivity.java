package com.example.gheorghetomoiaga.ordersexample.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gheorghetomoiaga.ordersexample.R;
import com.example.gheorghetomoiaga.ordersexample.adapters.OrderAdapter;
import com.example.gheorghetomoiaga.ordersexample.models.Order;
import com.example.gheorghetomoiaga.ordersexample.presenters.OrdersPresenter;
import com.example.gheorghetomoiaga.ordersexample.views.OrdersView;

import java.util.List;


public class OrdersActivity extends AppCompatActivity implements OrdersView, OrderAdapter.OrderClickListener {
    private OrdersPresenter ordersPresenter;
    private OrderAdapter adapter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        ordersPresenter = new OrdersPresenter(this);
        attachAdapter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ordersPresenter.dettachView();
        ordersPresenter = null;
        progressDialog = null;
    }

    @Override
    public void showLoading() {
        progressDialog = ProgressDialog.show(OrdersActivity.this, "",
                "Loading. Please wait...", true);
        progressDialog.setCanceledOnTouchOutside(false);
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void getDataSuccess(List<Order> ordersList) {
        for (Order order : ordersList) {
            adapter.addOrder(order);
        }
    }

    @Override
    public void getDataFail(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setTitle("Error");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void attachAdapter() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new OrderAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(int position){
        Order selectedOrder = adapter.getSelectedOrder(position);
        //Move To Details
    }
}
