package com.juiceman.StupideBench.controller;


import com.juiceman.StupideBench.exception.ResourceNotFoundException;
import com.juiceman.StupideBench.model.Products;
import com.juiceman.StupideBench.payload.ApiResponse;
import com.juiceman.StupideBench.payload.EditorRequest;
import com.juiceman.StupideBench.security.CurrentUser;
import com.juiceman.StupideBench.security.PersonPrincipal;
import com.juiceman.StupideBench.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ProductController {


    @Autowired
    private ProductService productService;


    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/getAllProduct")
    public List<Products> getAllProduct(){
        return productService.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/editorrproduct")
    public ResponseEntity<?> editorProduct(@CurrentUser PersonPrincipal currentUser, @RequestBody EditorRequest editorRequest){

        try{
            return productService.editorProduct(editorRequest);

        }catch(ResourceNotFoundException e){
            return new ResponseEntity(new ApiResponse(false, e.getMessage()),
                    HttpStatus.NOT_FOUND);
        }



    }
}
