package com.juiceman.StupideBench.repository;


import com.juiceman.StupideBench.model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvertoryRepository extends MongoRepository<Inventory, String> {



}
