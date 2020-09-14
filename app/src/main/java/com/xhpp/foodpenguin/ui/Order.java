package com.xhpp.foodpenguin.ui;

public class Order
{
    private String uid;
    private String id;
    private String shop_name;
    private String date;
    private double total_price;
    private int order_status;

    public Order (String uid, String id, String shop_name, String date, double total_price)
    {
        this.uid = uid;
        this.id = id;
        this.shop_name = shop_name;
        this.date = date;
        this.total_price = total_price;
        order_status = 1;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public int getOrder_status() {
        return order_status;
    }

    public void setOrder_status(int order_status) {
        this.order_status = order_status;
    }
}
