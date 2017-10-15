package com.cashup.services;

import com.cashup.entity.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAll();

    void addClient(Client client);

    Client getClient(int id);

    void deleteClient(int id);

    void updateClient(Client client);

}
