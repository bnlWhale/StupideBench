package com.juiceman.StupideBench.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="inventory")
public class Inventory extends UserDateAudit{

    @Id
    private String id;
    private String productId;
    private int amount;
    private String name;


    public Inventory(){

    }

    public Inventory(String id, String productId, int amount, String name){

        this.id = id;
        this.productId = productId;
        this.amount = amount;
        this.name = name;
    }

    public void reduceAmount(int num){
        if(amount>=num){
            amount -= num;
        }
    }

    public boolean checkAvailableNum(int num){
        return amount>=num;
    }


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
