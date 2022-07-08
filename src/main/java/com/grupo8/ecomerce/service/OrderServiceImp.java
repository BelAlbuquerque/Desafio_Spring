package com.grupo8.ecomerce.service;

import com.grupo8.ecomerce.dto.OrderRequestDto;
import com.grupo8.ecomerce.dto.OrderResponseDto;
import com.grupo8.ecomerce.model.Order;
import com.grupo8.ecomerce.model.Product;
import com.grupo8.ecomerce.repository.OrderRepository;
import com.grupo8.ecomerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
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
    public Order createOrder(List<OrderRequestDto> orderRequestDtoList) {
        productService.updateProducts(orderRequestDtoList);
        Order order = new Order();
        order.setId((long) (orderRepository.getAllOrders().size() + 1));
        order.setProductList(getDetailedProducts(orderRequestDtoList));
        order.setTotalPrice(getTotalPrice(getDetailedProducts(orderRequestDtoList)));
        orderRepository.createOrder(order);
        return order;
    }

    private List<Product> getDetailedProducts(List<OrderRequestDto> orderRequestDtoList) {
        return orderRequestDtoList.stream()
                .map(orderRequestDto -> {
                    Product foundedProduct = productService.getAllProducts().stream()
                            .filter(product -> product.getProductId().equals(orderRequestDto.getProductId()))
                            .collect(Collectors.toList()).get(0);
                        foundedProduct.setQuantity(orderRequestDto.getQuantity());
                        return foundedProduct;
                }).collect(Collectors.toList());
    }

}