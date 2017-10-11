package com.cashup.controller;

import com.cashup.entity.Client;
import com.cashup.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "/client", method = RequestMethod.GET)
    public List<Client> getAllClients() {
        return clientService.getAll();
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
    public Client getClient(@PathVariable(name = "id") int id) {
        return clientService.getClient(id);
    }

    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public void addClient(@RequestBody Client client) {
        clientService.addClient(client);
    }

    @RequestMapping(value = "/client/{id}", method = RequestMethod.DELETE)
    public void deleteClient(@PathVariable(name = "id") int id) {
        clientService.deleteClient(id);
    }

    @RequestMapping(value = "/client", method = RequestMethod.PUT)
    public void updateClient(@RequestBody Client client) {
        clientService.updateClient(client);
    }


}
