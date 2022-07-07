package com.grupo8.ecomerce.model;
import com.grupo8.ecomerce.dto.OrderRequestDto;
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
    private Double totalPrice;
    private List<OrderRequestDto> productList;
}
