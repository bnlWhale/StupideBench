package com.juiceman.StupideBench.payload;

import javax.validation.constraints.NotBlank;

public class ShoppingcartRequest {

    @NotBlank
    private String id;

    @NotBlank
    private Integer quantity;

    @NotBlank
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
