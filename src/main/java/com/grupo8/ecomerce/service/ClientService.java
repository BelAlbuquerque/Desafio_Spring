package com.grupo8.ecomerce.service;


import com.grupo8.ecomerce.model.Client;


import java.util.List;


public interface ClientService {

    void createClient(Client client) throws Exception;
    List<Client> getAllClient();
    Client getClientById(Client client) throws Exception;

}
