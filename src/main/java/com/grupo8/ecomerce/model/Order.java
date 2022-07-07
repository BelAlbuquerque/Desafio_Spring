package com.grupo8.ecomerce.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private Client client;
    private Double totalPrice;
    private List<Product> productList;
}
