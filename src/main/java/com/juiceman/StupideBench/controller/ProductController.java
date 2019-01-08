package com.juiceman.StupideBench.controller;


import com.juiceman.StupideBench.model.Products;
import com.juiceman.StupideBench.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;


    @RequestMapping("/api/getAllProduct")
    public List<Products> getAllProduct(){
        return productService.getAll();
    }

}
