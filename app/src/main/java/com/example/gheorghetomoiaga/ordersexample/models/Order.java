package com.example.gheorghetomoiaga.ordersexample.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Order implements Serializable{

    @SerializedName("id")
    private Integer id;

    @SerializedName("description")
    private String description;

    @SerializedName("price")
    private Integer price;

    @SerializedName("deliver_to")
    private String deliver_to;

    @SerializedName("picture")
    private String picture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDeliver_to() {
        return deliver_to;
    }

    public void setDeliver_to(String deliver_to) {
        this.deliver_to = deliver_to;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}

