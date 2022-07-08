package com.grupo8.ecomerce.service;

import com.grupo8.ecomerce.model.Order;
import com.grupo8.ecomerce.model.Product;
import com.grupo8.ecomerce.model.Purchase;
import com.grupo8.ecomerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderRepository orderRepository;

    private Double getTotalPrice(List<Product> productList) {
        return productList.stream()
                .mapToDouble(product -> product.getQuantity() * product.getPrice())
                .sum();
    }

    @Override
    public Order createOrder(List<Purchase> purchaseList) {
        productService.updateProducts(purchaseList);
        Order order = new Order();
        order.setId((long) (orderRepository.getAllOrders().size() + 1));
        order.setProductList(getDetailedProducts(purchaseList));
        order.setTotalPrice(getTotalPrice(getDetailedProducts(purchaseList)));
        orderRepository.createOrder(order);
        return order;
    }

    private List<Product> getDetailedProducts(List<Purchase> purchaseList) {
        return purchaseList.stream()
                .map(purchase -> {
                    Product foundedProduct = productService.getAllProducts().stream()
                            .filter(product -> product.getProductId().equals(purchase.getProductId()))
                            .collect(Collectors.toList()).get(0);
                        foundedProduct.setQuantity(purchase.getQuantity());
                        return foundedProduct;
                }).collect(Collectors.toList());
    }

}