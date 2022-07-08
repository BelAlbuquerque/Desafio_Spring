package com.grupo8.ecomerce.service;

import com.grupo8.ecomerce.model.Product;
import com.grupo8.ecomerce.model.Purchase;
import com.grupo8.ecomerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createProduct(Product newProduct) {
        productRepository.createProduct(newProduct);
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.getAllProducts();
        return productList;
    }

    @Override
    public List<Product> getByCategory(String category) {
        List<Product> productList = productRepository.getAllProducts();
        List<Product> productByCategoryList = productList.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
        return productByCategoryList;
    }

    @Override
    public List<Product> getByShipping(List<Product> productList) { // category avaliacao
        List<Product> productsFreeShipping = productList.stream()
                .filter(product -> product.getFreeShipping() == true)
                .collect(Collectors.toList());
        return productsFreeShipping;
    }

    @Override
    public List<Product> getByPrestige(String prestige) {
        List<Product> productList = productRepository.getAllProducts();
        List<Product> productsPrestige = productList.stream()
                .filter(product -> product.getPrestige().equals(prestige))
                .collect(Collectors.toList());
        return productsPrestige;
    }

    @Override
    public List<Product> getAllProductsOrder(int paramOrder) {
        if(paramOrder == 0) return getAllproductsOrderByAsc();
        if(paramOrder == 1) return getAllProductsOrderByDesc();
        if(paramOrder == 2) return getAllProductsOrderByHigherPrice();
        if(paramOrder == 3) return getAllProductsOrderBySmallerPrice();
        return null;
    }

    private List<Product> getAllproductsOrderByAsc() {
        return getAllProducts().stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
    }

    private List<Product> getAllProductsOrderByDesc() {
        return getAllProducts().stream()
                .sorted((product01, product02) -> -product01.getName().compareTo(product02.getName()))
                .collect(Collectors.toList());
    }

    private List<Product> getAllProductsOrderByHigherPrice() {
        return getAllProducts().stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
    }

    private List<Product> getAllProductsOrderBySmallerPrice() {
        return getAllProducts().stream()
                .sorted((product01, product02) -> -product01.getPrice().compareTo(product02.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public void updateProducts(List<Purchase> purchaseList) {
        List<Product> productList = getAllProducts();
        List<Product> updatedProductList = productList.stream().map(product -> {
            List<Purchase> founded = purchaseList.stream()
                    .filter(order -> order.getProductId().equals(product.getProductId())).collect(Collectors.toList());
            if (founded.size() != 0) {
                if (product.getQuantity() >= founded.get(0).getQuantity()) {
                    product.setQuantity(product.getQuantity() - founded.get(0).getQuantity());
                    return product;
                }
//                } else {
//                    throw new Exception("estoque insuficiente");
//                }
            }
            return product;
        }).collect(Collectors.toList());

        productRepository.updateProducts(updatedProductList);
    }

    //CRUD --> getProductById()
}
