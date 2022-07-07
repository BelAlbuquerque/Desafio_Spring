package com.grupo8.ecomerce.service;

import com.grupo8.ecomerce.dto.OrderRequestDto;
import com.grupo8.ecomerce.dto.OrderResponseDto;
import com.grupo8.ecomerce.model.Order;
import com.grupo8.ecomerce.model.Product;
import com.grupo8.ecomerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {

    @Autowired
    private ProductRepository productRepository;

//    @Override
//    public Double getTotalPrice(Order order) {
//        return null;
//    }

    @Override
    public OrderResponseDto createOrder(List<OrderRequestDto> orderRequestDtoList) {
        orderRequestDtoList.stream().forEach(orderRequestDto -> {
            verifyIfEnoughQuantity(orderRequestDto.getQuantity(), orderRequestDto.getProductId());
        });
    }

    private boolean verifyIfProductExist(Long productId) {
        List<Product> productList = productRepository.getAllProducts();
        return productList.stream().anyMatch(product -> product.getProductId().equals(productId));

    }
    private void verifyIfEnoughQuantity(Integer quantity,Long productId){
        if(verifyIfProductExist(productId)){
           updateQuantityProduct(quantity);
        }

    }

}
