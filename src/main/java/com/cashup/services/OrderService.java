package com.cashup.services;

import com.cashup.entity.Order;
import com.cashup.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(){
        return orderRepository.findOne(1);
    }

    public void saveOrder() {
        Order order = new Order();
        order.setClient(clientService.getClient());
        order.setCurrency(Order.Currency.EUR);
        order.setPrice(1000);
        order.setStatus(Order.Status.OPEN);
        order.setDate(Timestamp.valueOf(LocalDateTime.now()));

        orderRepository.save(order);
    }

}
