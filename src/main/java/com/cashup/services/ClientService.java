package com.cashup.services;

import com.cashup.entity.Client;
import com.cashup.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public void addClient() {
        Client client = new Client();
        client.setFirstName("test");
        client.setLastName("test");
        client.setInn(12345678);
        client.setSex(Client.Sex.MALE);
        client.setBirthday(new Date());

        clientRepository.save(client);
    }

    public Client getClient() {
        return clientRepository.findOne(1);
    }

}
