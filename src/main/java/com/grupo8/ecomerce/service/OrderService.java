package com.grupo8.ecomerce.service;

import com.grupo8.ecomerce.model.Order;

public interface OrderService {
    Double getTotalPrice(Order order);
}
