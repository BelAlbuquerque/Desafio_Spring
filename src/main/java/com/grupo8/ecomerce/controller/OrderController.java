package com.grupo8.ecomerce.controller;

import com.grupo8.ecomerce.dto.OrderRequestDto;
import com.grupo8.ecomerce.dto.OrderResponseDto;
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
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody List<OrderRequestDto> orderRequestDto) {
        OrderResponseDto responseDto = orderService.createOrder(orderRequestDto);
        return ResponseEntity.ok(responseDto);
    }
}
