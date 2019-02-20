package com.juiceman.StupideBench.service;

import com.juiceman.StupideBench.model.Shoppingcart;
import com.juiceman.StupideBench.payload.ApiResponse;
import com.juiceman.StupideBench.repository.ShoppingcartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ShoppingcartService {


    @Autowired
    private ShoppingcartRepository shoppingcartRepository;

    @Autowired
    private ProductService productService;


    public ResponseEntity<?> addItemIntoShoppingcart(String userName, String itemId, int quantity, String itemName){

        Shoppingcart shoppingcart = shoppingcartRepository.findByCreatedBy(userName).orElseGet(
                () -> new Shoppingcart(new ArrayList<>()));

        double price = productService.getCurrentPriceById(itemId);
        shoppingcart.modifyItem(itemId, quantity, itemName,price);
        shoppingcartRepository.save(shoppingcart);
        return ResponseEntity.ok(new ApiResponse(true, "This item was already modified! "));
    }


    public Shoppingcart getOwnShoppingcartByUsername(String userName){
        Shoppingcart shoppingcart = shoppingcartRepository.findByCreatedBy(userName).orElseGet(
                () -> new Shoppingcart(new ArrayList<>()));
        return shoppingcart;
    }

}
