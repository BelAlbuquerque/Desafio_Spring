package com.grupo8.ecomerce.controller;

import com.grupo8.ecomerce.dto.ProductDto;
import com.grupo8.ecomerce.model.Product;
import com.grupo8.ecomerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product newProduct){
        productService.createProduct(newProduct);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productDtoList = ProductDto.convertDto(productService.getAllProducts());
        return ResponseEntity.ok(productDtoList);
    }

    @GetMapping("/products/{category}")
    public ResponseEntity<List<ProductDto>> getByCategory(@PathVariable String category) {
      List<ProductDto> listByCategory = ProductDto.convertDto(
              productService.getByCategory(category)
      );;
        return  ResponseEntity.ok(listByCategory);
    }

    @GetMapping("/products/freeshipping/")
    public ResponseEntity<List<ProductDto>> getByCategoryAndShipping(
            @RequestParam String category) {
        List<ProductDto> listFreeShippingCategory = ProductDto.convertDto(
                productService.getByShipping(productService.getByCategory(category))
        );
        return ResponseEntity.ok(listFreeShippingCategory);
    }

}
// products/esporte/bolean
// products/boolean/string