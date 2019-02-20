package com.juiceman.StupideBench.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@Document(collection = "orders")
public class Orders extends DateAudit {

    @Id
    private String id;
    private String user_id;
    private Instant purchase_date;
    private Address shipping_address;
    private double sub_total;
    private OrderState state;
    private List<LineItem> line_items;

    public Orders() {

    }

    public Orders(String id, String user_id, Instant purchase_date, Address shipping_address,
                  double sub_total, OrderState state, List<LineItem> line_items) {
        this.id = id;
        this.user_id = user_id;
        this.purchase_date = purchase_date;
        this.shipping_address = shipping_address;
        this.sub_total = sub_total;
        this.state = state;
        this.line_items = line_items;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instant getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Instant purchase_date) {
        this.purchase_date = purchase_date;
    }

    public Address getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(Address shipping_address) {
        this.shipping_address = shipping_address;
    }

    public double getSub_total() {
        return sub_total;
    }

    public void setSub_total(double sub_total) {
        this.sub_total = sub_total;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public List<LineItem> getLine_items() {
        return line_items;
    }

    public void setLine_items(List<LineItem> line_items) {
        this.line_items = line_items;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
