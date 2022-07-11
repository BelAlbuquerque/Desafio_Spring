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
    public void createProduct(@RequestBody Product newProduct) {
        productService.createProduct(newProduct);
    }

    /**
     * Este metodo retorna para cliente uma lista de produtos disponiveis
     * @return List Product
     */
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productDtoList = ProductDto.convertDto(productService.getAllProducts());
        return ResponseEntity.ok(productDtoList);
    }

    /**
     *  Este metodo retorna uma de produto filtrado por categoria
     * @param category
     * @return lista de categoria
     */
    @GetMapping("/products/{category}")
    public ResponseEntity<List<ProductDto>> getByCategory(@PathVariable String category) {
        List<ProductDto> listByCategory = ProductDto.convertDto(
                productService.getByCategory(category));
        return ResponseEntity.ok(listByCategory);
    }

    /**
     * Este metodo retorna para o cliente  lista frete gratis
     * @param category
     * @return Lista de frete gratis
     */
    @GetMapping("/products/freeshipping/")
    public ResponseEntity<List<ProductDto>> getByCategoryAndShipping(
            @RequestParam String category) {
        List<ProductDto> listFreeShippingCategory = ProductDto.convertDto(
                productService.getByShipping(productService.getByCategory(category)));
        return ResponseEntity.ok(listFreeShippingCategory);
    }

    /**
     * Este metodo retorna para cliente uma  lista de frete gratis mais prestige ***
     * @param prestige
     */
    @GetMapping("/products/freeshipping/{prestige}")
    public ResponseEntity<List<ProductDto>> getByShippingAndPrestige(
            @PathVariable String prestige) {
        List<ProductDto> listFreeShippingPrestige = ProductDto.convertDto(
                productService.getByShipping(productService.getByPrestige(prestige)));
        return ResponseEntity.ok(listFreeShippingPrestige);
    }

    /**
     * Este metodo recebe como parametro um int de 0 a 3 que retorna para cliente uma lista de produtos ordenadas, se:
     * 0 Alfabético crescente.
     * 1 Alfabético decrescente.
     * 2 Maior a menor preço
     * 3 Menor a maior preço.
     * @param number
     */
    @GetMapping("products/orderby/{number}")
    public ResponseEntity<List<ProductDto>> getAllProductsOrderByName(
            @PathVariable int number
    ) {
        List<ProductDto> listOrderByName = ProductDto.convertDto(productService.getAllProductsOrder(number));
        return ResponseEntity.ok(listOrderByName);
    }
}
