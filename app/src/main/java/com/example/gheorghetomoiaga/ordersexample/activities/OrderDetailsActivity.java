package com.example.gheorghetomoiaga.ordersexample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gheorghetomoiaga.ordersexample.R;
import com.example.gheorghetomoiaga.ordersexample.models.Order;
import com.example.gheorghetomoiaga.ordersexample.utils.Utils;


public class OrderDetailsActivity extends AppCompatActivity{
    private TextView personName, orderId, flowerPrice, orderDescription;
    private ImageView flowerPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        addBackButton();
        setUpViews();
    }

    private void addBackButton() {
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    private void setUpViews(){
        Intent intent = getIntent();
        Order order = (Order) intent.getSerializableExtra(OrdersActivity.ORDER_DETAIL);
        initViews();
        renderViews(order);
    }

    private void initViews(){
        flowerPhoto = findViewById(R.id.order_details_imageView);
        personName = findViewById(R.id.personName);
        orderId = findViewById(R.id.orderId);
        flowerPrice = findViewById(R.id.flowerPrice);
        orderDescription = findViewById(R.id.orderDescription);
    }

    private void renderViews(Order order){
        flowerPhoto.setImageBitmap(Utils.getBitmapByEncodedString(order.getPicture()));
        personName.setText(order.getDeliver_to());
        orderId.setText(Double.toString(order.getId()));
        flowerPrice.setText("$"+ order.getPrice());
        orderDescription.setText(order.getDescription());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return super.onOptionsItemSelected(item);
    }

}

