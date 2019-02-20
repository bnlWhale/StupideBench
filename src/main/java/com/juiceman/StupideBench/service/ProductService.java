package com.juiceman.StupideBench.service;

import com.juiceman.StupideBench.controller.CheckoutController;
import com.juiceman.StupideBench.exception.ResourceNotFoundException;
import com.juiceman.StupideBench.model.Inventory;
import com.juiceman.StupideBench.model.Pricing;
import com.juiceman.StupideBench.model.Products;
import com.juiceman.StupideBench.payload.ApiResponse;
import com.juiceman.StupideBench.payload.EditorRequest;
import com.juiceman.StupideBench.payload.SignUpRequest;
import com.juiceman.StupideBench.repository.InventoryRepository;
import com.juiceman.StupideBench.repository.ProductRepository;
import com.juiceman.StupideBench.security.CurrentUser;
import com.juiceman.StupideBench.security.PersonPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public List<Products> getAll(){
        return productRepository.findAll();
    }



    public double getCurrentPriceById(String id){

        Products p = productRepository.findById(id).orElseGet(()->( new Products()));

        return p.getCurrentPrice();
    }


    @Transactional
    public ResponseEntity<?> editorProduct(@RequestBody EditorRequest editorRequest){

        Products p = null;
        if(editorRequest.getId().equals("no_id")){
             p = new Products();
        }else{
             p = productRepository.findById(editorRequest.getId()).orElseThrow(()->new ResourceNotFoundException("product", "find by id", editorRequest.getId()));
        }

        p.description = editorRequest.getDescription();
        p.pricing = new Pricing();
        p.pricing.retail = editorRequest.getPrice();
        p.name = editorRequest.getProductName();


        Products p1 = productRepository.findById("4c4b1476238d3b4dd5003981").orElseThrow(()->new ResourceNotFoundException("product", "find by id", 3981));
        p.details = p1.details;
        p.category_ids = p1.category_ids;
        p.average_review = p1.average_review;
        p.total_reviews = p1.total_reviews;
        p.tags = p1.tags;
        p.sku = p1.sku+(int)(Math.random() * 100 + 1);
        p.slug = p1.slug+(int)(Math.random() * 100 + 1);
        p = productRepository.save(p);
        String newId = p.id;



        Inventory inventory = new Inventory();
        inventory.setProductId(newId);
        inventory.setAmount(editorRequest.getQuantity());
        inventory.setName(p.name);

        inventoryRepository.save(inventory);

        if(editorRequest.getId().equals("no_id")){
            return ResponseEntity.ok(new ApiResponse(true, " This product was created successful. "));

        }
        return ResponseEntity.ok(new ApiResponse(true, "This action is completed"));



    }
}
