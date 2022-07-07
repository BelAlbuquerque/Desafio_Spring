package com.grupo8.ecomerce.service;

import com.grupo8.ecomerce.model.Order;
import com.grupo8.ecomerce.model.Product;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService{
    @Override
    public Double getTotalPrice(Order order) {
        return order.getProductList().stream()
            .mapToDouble(Product::getPrice)
            .sum();
    }
}