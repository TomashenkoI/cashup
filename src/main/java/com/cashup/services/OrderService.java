package com.cashup.services;

import com.cashup.entity.Order;
import com.cashup.repository.ClientRepository;
import com.cashup.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private ClientRepository clientRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository) {
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
}
