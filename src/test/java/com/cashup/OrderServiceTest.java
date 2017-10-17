package com.cashup;

import com.cashup.entity.Client;
import com.cashup.entity.Order;
import com.cashup.services.ClientService;
import com.cashup.services.OrderService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static com.cashup.entity.Order.Currency.UAH;
import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientService clientService;

    private Order testOrder;
    private Client testClient;

    @Before
    public void setup() {
        testClient = new Client();
        testClient.setId(9999);
        testClient.setFirstName("Test");
        testClient.setLastName("Test");
        testClient.setInn(12345678);
        testClient.setBirthday(new Date());
        testClient.setSex(Client.Sex.FEMALE);

        clientService.addClient(testClient);

        testClient.setId(clientService.getClientByLastName("Test").getId());

        testOrder = new Order();
        testOrder.setStatus(Order.Status.OPEN);
        testOrder.setCurrency(UAH);
        testOrder.setDate(Timestamp.valueOf(LocalDateTime.now()));
        testOrder.setPrice(9999);
        testOrder.setClient(testClient);

        orderService.saveOrder(testOrder);

        testOrder.setId(orderService.getOrdersByClient(testClient.getId()).get(0).getId());
    }

    @After
    public void remove() {
        orderService.deleteOrder(testOrder.getId());
        clientService.deleteClient(testClient.getId());
    }

    @Test
    public void testSave() {
        assertEquals(testOrder.getId(), orderService.getOrder(testOrder.getId()).getId());
    }

    @Test
    public void testUpdate() {
        Order order = orderService.getOrder(testOrder.getId());
        int testPrice = 1111;
        order.setPrice(testPrice);

        orderService.updateOrder(order);

        assertEquals(testPrice, orderService.getOrder(order.getId()).getPrice());
    }

    @Test
    public void testGetClientOrders() {
        List<Order> ordersByClient = orderService.getOrdersByClient(testClient.getId());

        assertEquals(testOrder.getId(), ordersByClient.get(0).getId());
    }

    @Test
    public void testConfirmOrder() {
        orderService.confirmOrder(testOrder.getId());

        assertEquals(Order.Status.CONFIRMED, orderService.getOrder(testOrder.getId()).getStatus());
    }

}
