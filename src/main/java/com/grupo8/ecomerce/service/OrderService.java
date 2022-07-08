package com.grupo8.ecomerce.service;

import com.grupo8.ecomerce.model.Order;
import com.grupo8.ecomerce.model.Purchase;

import java.util.List;

public interface OrderService {
        Order createOrder(List<Purchase> purchase);
}
