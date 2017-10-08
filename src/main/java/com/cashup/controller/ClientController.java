package com.cashup.controller;

import com.cashup.entity.Client;
import com.cashup.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public List<Client> getAllClients() {
        return clientService.getAll();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Client getClient() {
        return clientService.getClient();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void addClient() {
        clientService.addClient();
    }

}
