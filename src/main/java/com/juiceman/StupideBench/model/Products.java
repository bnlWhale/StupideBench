package com.juiceman.StupideBench.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "products")
public class Products {

    @Id
    public String id;
    public String slug;
    public String sku;
    public String name;
    public String description;
    public ItemDetail details;
    public double total_reviews;
    public double average_review;
    public Pricing pricing;
    public List<PriceHistory> price_history;
    public List<ObjectId> category_ids;
    public ObjectId main_cat_id;
    public List<String> tags;


    public Products(String id, String slug, String sku, String name, String description, ItemDetail details,
                    double total_reviews, double average_review, Pricing pricing, List<PriceHistory> price_history,
                    List<ObjectId> category_ids, ObjectId main_cat_id, List<String> tags){
        this.id = id;
        this.slug = slug;
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.details = details;
        this.total_reviews = total_reviews;
        this.average_review = average_review;
        this.pricing = pricing;
        this.price_history = price_history;
        this.category_ids = category_ids;
        this.main_cat_id = main_cat_id;
        this.tags = tags;
    }


    public String toString(){
        return this.name+" "+this.slug;
    }

}

