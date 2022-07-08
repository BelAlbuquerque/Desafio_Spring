package com.grupo8.ecomerce.service;

import com.grupo8.ecomerce.dto.OrderRequestDto;
import com.grupo8.ecomerce.model.Order;

import java.util.List;

public interface OrderService {
        Order createOrder(List<OrderRequestDto> order);
}
