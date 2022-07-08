package com.grupo8.ecomerce.service;


import com.grupo8.ecomerce.model.Client;


import java.util.List;


public interface ClientService {

    void createClient(Client client) throws Exception;
    List<Client> getAllClient();
    List<Client> getByState(String state);
    Client getClientById(Long id) throws Exception;

}
