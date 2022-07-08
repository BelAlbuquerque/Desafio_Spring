package com.grupo8.ecomerce.service;

import com.grupo8.ecomerce.model.Order;
import com.grupo8.ecomerce.model.Product;
import com.grupo8.ecomerce.model.Purchase;
import com.grupo8.ecomerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImp implements OrderService {

    /**
     * Injeção de dependência do Service: Product
     */
    @Autowired
    private ProductService productService;

    /**
     * Injeção de dependência do Repository: Order
     */
    @Autowired
    private OrderRepository orderRepository;

    /**
     * Método responsável por retornar o preço total da compra.
     * @param productList Lista dos produtos comprados
     * @return Total da compra
     */
    private Double getTotalPrice(List<Product> productList) {
        return productList.stream()
                .mapToDouble(product -> product.getQuantity() * product.getPrice())
                .sum();
    }

    /**
     * Método responsável por criar uma ordem de compra.
     * Neste método também há uma chamada do método updateProducts(), para atualizar a quantidade em estoque.
     * @param purchaseList Pedido de compra contendo ID do produto e a quantidade
     * @return Ordem de compra completa
     */
    @Override
    public Order createOrder(List<Purchase> purchaseList) {
        productService.updateProducts(purchaseList);
        Order order = new Order();
        order.setId((long) (orderRepository.getAllOrders().size() + 1));
        order.setProductList(getDetailedProducts(purchaseList));
        order.setTotalPrice(getTotalPrice(getDetailedProducts(purchaseList)));
        orderRepository.createOrder(order);
        return order;
    }

/**
 * Método responsável por retornar uma lista de produtos com todas as suas informações pertinentes.
 * @param purchaseList Lista dos produtos comprados, contendo ID do produto e a quantidade.
 * @return Lista completa dos produtos comprados.
 */
    private List<Product> getDetailedProducts(List<Purchase> purchaseList) {
        return purchaseList.stream()
                .map(purchase -> {
                    Product foundedProduct = productService.getAllProducts().stream()
                            .filter(product -> product.getProductId().equals(purchase.getProductId()))
                            .collect(Collectors.toList()).get(0);
                        foundedProduct.setQuantity(purchase.getQuantity());
                        return foundedProduct;
                }).collect(Collectors.toList());
    }
}