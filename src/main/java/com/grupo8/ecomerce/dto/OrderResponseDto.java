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
public class OrderResponseDto {

    private Double totalPrice;

    public OrderResponseDto(Order order) {
        this.totalPrice = order.getTotalPrice();
    }

    public static List<OrderResponseDto> convertDto(List<Order> listOrder) {
        return listOrder.stream().map(OrderResponseDto::new).collect(Collectors.toList());
    }
}
