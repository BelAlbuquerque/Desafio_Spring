package com.grupo8.ecomerce.service;

import com.grupo8.ecomerce.model.Product;
import com.grupo8.ecomerce.model.Purchase;

import java.util.List;

public interface ProductService {

    void createProduct(Product newProduct);

    List<Product> getAllProducts();

    List<Product> getByCategory(String category);

    List<Product> getByShipping(List<Product> list);

    List<Product> getByPrestige(String prestige);

    List<Product> getAllProductsOrder(int paramOrder);

    void updateProducts(List<Purchase> purchaseList);
}
