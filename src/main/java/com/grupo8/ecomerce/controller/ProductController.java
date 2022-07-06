package com.grupo8.ecomerce.controller;

import com.grupo8.ecomerce.model.Product;
import com.grupo8.ecomerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService product;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product newProduct){
        product.createProduct(newProduct);
    }

}
