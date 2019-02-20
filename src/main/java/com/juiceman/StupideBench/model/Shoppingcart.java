package com.juiceman.StupideBench.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.juiceman.StupideBench.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document(collection = "shoppingcart")
public class Shoppingcart extends UserDateAudit{

    @Id
    private String id;
    private List<ShoppingcartItem> items;

    @JsonIgnore
    @Transient
    private Map<String, ShoppingcartItem> itemsMap= new HashMap<>();

    public Shoppingcart(List<ShoppingcartItem> items){
        this.items = items;
        for(ShoppingcartItem item: this.items){
            itemsMap.put(item.itemId, item);
        }
    }

    public void reSetItemList(){

        items = new ArrayList<>();
        itemsMap.clear();
    }

    public void modifyItem(String itemId, int quantity, String itemName, double price){

        ShoppingcartItem item;
        if(itemsMap.containsKey(itemId)){
            item = itemsMap.get(itemId);
            item.itemQuantity += quantity;
            item.lastModified = Instant.now();
            if(item.itemQuantity<1){
                itemsMap.remove(itemId);
                items.remove(item);
            }
        }else{
            item = new ShoppingcartItem();
            item.itemId = itemId;
            item.itemQuantity = quantity;
            item.name = itemName;
            item.lastModified = Instant.now();
            itemsMap.put(itemId, item);
            item.price = price;
            items.add(item);
        }

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ShoppingcartItem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingcartItem> items) {
        this.items = items;
    }
}
