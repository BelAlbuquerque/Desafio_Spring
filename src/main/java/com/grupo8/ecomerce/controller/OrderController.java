package com.grupo8.ecomerce.controller;

import com.grupo8.ecomerce.model.Order;
import com.grupo8.ecomerce.model.Purchase;
import com.grupo8.ecomerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Order> createOrder(@RequestBody List<Purchase> purchase) {
        Order response = orderService.createOrder(purchase);
        return ResponseEntity.ok(response);
    }
}
