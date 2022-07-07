package com.grupo8.ecomerce.dto;

import com.grupo8.ecomerce.model.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {

    private Double totalPrice;

    public OrderDto(Order order) {
        this.totalPrice = order.getTotalPrice();
    }

    public static List<OrderDto> convertDto(List<Order> listOrder) {
        return listOrder.stream().map(OrderDto::new).collect(Collectors.toList());
    }
}
