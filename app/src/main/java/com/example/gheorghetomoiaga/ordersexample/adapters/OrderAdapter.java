package com.example.gheorghetomoiaga.ordersexample.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gheorghetomoiaga.ordersexample.R;
import com.example.gheorghetomoiaga.ordersexample.models.Order;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {
    private List<Order> orders;
    private OrderClickListener listener;

    public OrderAdapter(OrderClickListener listener){
        orders = new ArrayList<>();
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_order, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Order currentOrder = orders.get(position);
        holder.personName.setText(currentOrder.getDeliverTo());
        holder.flowerPrice.setText(Double.toString(currentOrder.getPrice())+"$");

        Picasso.with(holder.itemView.getContext())
                .load("http://services.hanselandpetal.com/photos/" + currentOrder.getPhoto())
                .into(holder.flowerPhoto);
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public void addOrder(Order order) {
        orders.add(order);
        notifyDataSetChanged();
    }

    public Order getSelectedOrder(int position){
        return  orders.get(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView flowerPhoto;
        public TextView personName, flowerPrice;

        public MyViewHolder(View itemView) {
            super(itemView);
            flowerPhoto = itemView.findViewById(R.id.imageView);
            personName = itemView.findViewById(R.id.headingView);
            flowerPrice = itemView.findViewById(R.id.priceView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(getLayoutPosition());
        }
    }

    public interface OrderClickListener {
        void onClick(int position);
    }

}
