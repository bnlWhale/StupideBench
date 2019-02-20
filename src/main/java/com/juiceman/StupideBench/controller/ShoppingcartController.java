package com.juiceman.StupideBench.controller;


import com.juiceman.StupideBench.model.Shoppingcart;
import com.juiceman.StupideBench.payload.ShoppingcartRequest;
import com.juiceman.StupideBench.security.CurrentUser;
import com.juiceman.StupideBench.security.PersonPrincipal;
import com.juiceman.StupideBench.service.ShoppingcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/")
public class ShoppingcartController {

    @Autowired
    private ShoppingcartService shoppingcartService;

    @PostMapping("/addIntoShoppingcart")
    public ResponseEntity<?> addItemIntoShoppingcart(@CurrentUser PersonPrincipal currentUser, @RequestBody ShoppingcartRequest shoppingcartRequest){

        return shoppingcartService.addItemIntoShoppingcart(currentUser.getUsername(), shoppingcartRequest.getId(), shoppingcartRequest.getQuantity(), shoppingcartRequest.getName());
    }

    @GetMapping("/getOwnShoppingCart")
    public Shoppingcart getOwnShoppingCart(@CurrentUser PersonPrincipal currentUser){
        return  shoppingcartService.getOwnShoppingcartByUsername(currentUser.getUsername());
    }
}
