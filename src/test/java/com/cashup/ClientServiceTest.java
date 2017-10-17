package com.cashup;

import com.cashup.entity.Client;
import com.cashup.services.ClientService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    private Client testClient;

    @Before
    public void setup() {
        testClient = new Client();
        testClient.setFirstName("Test");
        testClient.setLastName("Test");
        testClient.setInn(12345678);
        testClient.setBirthday(new Date());
        testClient.setSex(Client.Sex.FEMALE);

        clientService.addClient(testClient);
        testClient.setId(clientService.getClientByLastName(testClient.getLastName()).getId());
    }

    @Test
    public void testSave() {
        assertNotNull(clientService.getClientByLastName(testClient.getLastName()));
    }

    @Test
    public void testUpdate() {
        Client client = clientService.getClient(testClient.getId());
        int testInn = 00000000;

        client.setInn(testInn);

        clientService.updateClient(client);

        assertEquals(testInn, client.getInn());
    }

    @After
    public void remove() {
        clientService.deleteClient(testClient.getId());
    }

}
