package com.juiceman.StupideBench.service;


import com.juiceman.StupideBench.exception.NumNotAvailalbeException;
import com.juiceman.StupideBench.exception.ResourceNotFoundException;
import com.juiceman.StupideBench.model.*;
import com.juiceman.StupideBench.repository.InventoryRepository;
import com.juiceman.StupideBench.repository.OrdersRepository;
import com.juiceman.StupideBench.repository.ShoppingcartRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class CheckoutService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ShoppingcartRepository shoppingcartRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    private static final Logger logger = LoggerFactory.getLogger(CheckoutService.class);

    @Transactional
    public void checkoutOnShoppingcart(String userName, String userId, Address address){

        Shoppingcart cart = shoppingcartRepository.findByCreatedBy(userName).orElseThrow(()->
                new ResourceNotFoundException("shoppingcart","createBy", userName ));
        List<ShoppingcartItem> items = cart.getItems();
        List<LineItem> lineItemList = null;
        double subTotal = 0;
        for(ShoppingcartItem item : items){
             String item_id = item.itemId;
             int item_quantity = item.itemQuantity;
             if(item_quantity>0){
                 Inventory  inventory = inventoryRepository.findByProductId(item_id).orElseThrow(()->
                         new ResourceNotFoundException("inventory","name", item.name ));

                 if(!inventory.checkAvailableNum(item_quantity)){
                     throw new NumNotAvailalbeException(item.name, "quantity", "inventory");
                 }
                 inventory.reduceAmount(item_quantity);
                 inventoryRepository.save(inventory);

                 LineItem lineItem = new LineItem();
                 lineItem.setId(item_id);
                 lineItem.setName(item.name);
                 lineItem.setPricing(new Pricing(item.price));
                 lineItem.setQuantity(item_quantity);

                 if(lineItemList == null){
                     lineItemList = new ArrayList<>();
                 }
                 lineItemList.add(lineItem);
                 subTotal += item_quantity*item.price;

             }
        }//end for

        if(lineItemList != null){
            Orders orders = new Orders();
            orders.setLine_items(lineItemList);
            orders.setState(OrderState.CREATED);
            orders.setUser_id(userId);
            orders.setSub_total(subTotal);
            orders.setShipping_address(address);
            orders.setPurchase_date(java.time.Instant.now());
            ordersRepository.save(orders);

            cart.reSetItemList();
            shoppingcartRepository.save(cart);
        }

    }


}
