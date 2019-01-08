package com.juiceman.StupideBench.repository;

import com.juiceman.StupideBench.model.Products;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Products,String> {

    public List<Products> findByName(String name);
}
