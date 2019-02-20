package com.juiceman.StupideBench.service;


import com.juiceman.StupideBench.model.Orders;
import com.juiceman.StupideBench.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersHistoryService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private MongoTemplate mongoTemplate;


    public List<Orders> getOrdersByUserId(String userId){

        Query query = new Query();
        query.addCriteria(Criteria.where("user_id").is(userId));
        List<Orders> list = mongoTemplate.find(query,Orders.class);
        if(list == null){
            list = new ArrayList<Orders>();
        }
        return list;
        //return ordersRepository.findAllByUser_id(userId).orElseGet(()->new ArrayList<>());
    }


}
