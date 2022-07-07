package com.grupo8.ecomerce.service;

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

    @Override
    public Double getTotalPrice(Order order) {
        return null;
    }
    // @Override
    //  public Double getTotalPrice(Order order) {
    //  return order.getProductList().stream()
    //   .mapToDouble(Product::getPrice)
    //.sum();

    private boolean verifyIfProductExist(Long productId) {
        List<Product> productList = productRepository.getAllProducts();
        return productList.stream().anyMatch(product -> product.getProductId().equals(productId));

    }
    private void verifyIfQuantity(Integer quantity,Long productId){
        if(verifyIfProductExist(productId)){
           updateQuantityProduct();
        }

    }

}
