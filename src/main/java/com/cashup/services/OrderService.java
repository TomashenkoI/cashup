package com.cashup.services;

import com.cashup.entity.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    Order getOrder(int id);

    void saveOrder(Order order);

    void deleteOrder(int id);

    void updateOrder(Order order);

    List<Order> getOrdersByClient(int id);

    void confirmOrder(int id);

}
