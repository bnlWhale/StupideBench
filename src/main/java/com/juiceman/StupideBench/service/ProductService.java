package com.juiceman.StupideBench.service;

import com.juiceman.StupideBench.model.Products;
import com.juiceman.StupideBench.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAll(){
        return productRepository.findAll();
    }
}
