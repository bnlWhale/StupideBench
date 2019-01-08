package com.juiceman.StupideBench.repository;

import java.util.List;

import com.juiceman.StupideBench.model.Categories;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Categories, String>{

    public List<Categories> findAll();

}
