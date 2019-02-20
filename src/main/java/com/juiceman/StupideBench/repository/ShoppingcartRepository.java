package com.juiceman.StupideBench.repository;



import com.juiceman.StupideBench.model.Shoppingcart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingcartRepository extends MongoRepository<Shoppingcart, String> {

   Optional<Shoppingcart> findByCreatedBy(String createBy);

}
