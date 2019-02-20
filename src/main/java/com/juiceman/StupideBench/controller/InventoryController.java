package com.juiceman.StupideBench.controller;


import com.juiceman.StupideBench.model.Inventory;
import com.juiceman.StupideBench.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getCurrentInventoryList")
    public List<Inventory> getCurrentInventoryList(){

        return inventoryRepository.findAll();
    }
}
