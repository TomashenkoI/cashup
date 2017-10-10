package com.cashup.controller;

import com.cashup.entity.Order;
import com.cashup.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public Order getOrderById(@PathVariable(name = "id") int id) {
        return orderService.getOrder(id);
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public void deleteOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }

    @RequestMapping(value = "/order/{id}" , method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable(name = "id") int id) {
        orderService.deleteOrder(id);
    }

    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    public void updateOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
    }

    @RequestMapping(value = "/order/client/{id}", method = RequestMethod.GET)
    public List<Order> getOrdersByClientId(@PathVariable(name = "id") int id) {
        return orderService.getOrdersByClient(id);
    }

    @RequestMapping(value = "/order/{id}/confirm", method = RequestMethod.GET)
    public void confirmOrder(@PathVariable(name = "id") int id) {
        orderService.confirmOrder(id);
    }
}
