package com.juiceman.StupideBench.controller;


import com.juiceman.StupideBench.model.Orders;
import com.juiceman.StupideBench.security.CurrentUser;
import com.juiceman.StupideBench.security.PersonPrincipal;
import com.juiceman.StupideBench.service.OrdersHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class OrdersHistoryController {

    @Autowired
    private OrdersHistoryService ordersHistoryService;

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/getOrdersHistoryList")
    public List<Orders> getOrdersHistoryList(@CurrentUser PersonPrincipal currentUser) {
        return ordersHistoryService.getOrdersByUserId(currentUser.getId());
    }

}
