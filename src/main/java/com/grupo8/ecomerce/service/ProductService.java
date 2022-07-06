package com.grupo8.ecomerce.service;

import com.grupo8.ecomerce.dto.ProductDto;
import com.grupo8.ecomerce.model.Product;

import java.util.List;

public interface ProductService {

    void createProduct(Product newProduct);

    List<Product> getAllProducts();

    List<Product> getByCategory(String category);

}
