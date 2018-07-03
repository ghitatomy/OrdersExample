package com.example.gheorghetomoiaga.ordersexample.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.gheorghetomoiaga.ordersexample.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addCheckOrdersButton();
    }

    private void addCheckOrdersButton() {
        final Button button = findViewById(R.id.check_orders_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendStartOrdersActivity();
            }
        });
    }

    public void sendStartOrdersActivity() {
        Intent intent = new Intent(this, OrdersActivity.class);
        startActivity(intent);
    }


}
