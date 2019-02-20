package com.juiceman.StupideBench.repository;

import com.juiceman.StupideBench.model.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends MongoRepository<Orders, String> {

    //Optional<List<Orders>> findAllByUser_id(String user_id);


}
