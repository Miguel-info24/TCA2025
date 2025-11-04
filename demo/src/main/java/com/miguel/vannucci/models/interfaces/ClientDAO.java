package com.miguel.vannucci.models.interfaces;

import java.util.List;

import com.miguel.vannucci.models.Client;

public interface ClientDAO {

    int addClient(Client client);
    boolean updateClient(Client client);
    boolean deleteClient(int clientId);
    Client getClientById(int clientId);
    List<Client> getClients();
}
