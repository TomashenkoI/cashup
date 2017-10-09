package com.cashup.controller;

import com.cashup.entity.Order;
import com.cashup.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/save" , method = RequestMethod.GET)
    public void saveOrder() {
        orderService.saveOrder();
    }

}
