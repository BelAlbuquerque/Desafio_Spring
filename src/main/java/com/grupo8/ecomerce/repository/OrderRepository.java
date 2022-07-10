package com.grupo8.ecomerce.repository;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.grupo8.ecomerce.exceptions.NotFound;
import com.grupo8.ecomerce.exceptions.ServerError;
import com.grupo8.ecomerce.model.Order;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class OrderRepository {

    private final String pathOrder = "src/main/resources/order.json";

    /**
     *Este metodo simulando a criando de um  pedido do cliente
     * @param newOrder
     */
    public void createOrder (Order newOrder){
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        List<Order> orderList = null;

        try{
            orderList = Arrays.asList(mapper.readValue(new File(pathOrder), Order[].class));
            List<Order> copyListOrder = new ArrayList<>(orderList);
            copyListOrder.add(newOrder);
            writer.writeValue(new File(pathOrder), copyListOrder);

        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new ServerError("Erro Interno no Servidor.");

        }
    }

    /**
     * Metodo retorna todos os pedidos de compra
     * @return Lista Order
     */
    public List<Order> getAllOrders() {
        ObjectMapper mapper = new ObjectMapper();
        List<Order> orderList = null;

        try {
            orderList = Arrays.asList(mapper.readValue(new File(pathOrder), Order[].class));
        } catch (Exception e ) {
            System.out.println(e.getMessage());
            throw new ServerError("Erro Interno no Servidor.");
        }
        if (orderList.size() < 1) throw new NotFound("Nenhum pedido registrado.");
        return  orderList;
    }
}
