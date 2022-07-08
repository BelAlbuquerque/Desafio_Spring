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

    /**
     * Metodo construtor
     * @param order
     */
    public OrderResponseDto(Order order) {
        this.totalPrice = order.getTotalPrice();
    }
//revisar a utilizacao
    public static List<OrderResponseDto> convertDto(List<Order> listOrder) {
        return listOrder.stream().map(OrderResponseDto::new).collect(Collectors.toList());
    }
}
