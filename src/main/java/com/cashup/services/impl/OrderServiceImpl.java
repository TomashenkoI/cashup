package com.cashup.services.impl;

import com.cashup.entity.Order;
import com.cashup.repository.ClientRepository;
import com.cashup.repository.OrderRepository;
import com.cashup.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private ClientRepository clientRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(int id){
        return orderRepository.findOne(id);
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteOrder(int id) {
        orderRepository.delete(id);
    }

    public void updateOrder(Order order) {
        orderRepository.saveAndFlush(order);
    }

    public List<Order> getOrdersByClient(int id) {
        return orderRepository.findByClient(clientRepository.getOne(id));
    }

    public void confirmOrder(int id) {
        Order order = orderRepository.findOne(id);
        order.setStatus(Order.Status.CONFIRMED);

        orderRepository.saveAndFlush(order);
    }
}
