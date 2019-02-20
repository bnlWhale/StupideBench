package com.juiceman.StupideBench.model;

public class LineItem {

    private String id;
    private Pricing pricing;
    private String name;
    private int quantity;

    public LineItem(){

    }

    public LineItem(String id, Pricing pricing, String name, int quantity){

        this.id = id;
        this.pricing = pricing;
        this.name = name;
        this.quantity = quantity;

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
