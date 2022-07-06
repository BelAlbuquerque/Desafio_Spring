package com.grupo8.ecomerce.dto;

import com.grupo8.ecomerce.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

    private Long productId;
    private String name;
    private Integer quantity;

    public ProductDto(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.quantity = product.getQuantity();
    }
}
