package com.grupo8.ecomerce.service;

import com.grupo8.ecomerce.model.Client;
import com.grupo8.ecomerce.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImp implements ClientService{

    @Autowired
    private ClientRepository clienteRepository;

    @Override
    public void createClient(Client client) throws Exception {
        Client clientExist = clienteRepository.getClientById(client.getId());
        if (!clientExist.getId().equals(client.getId())){
            clienteRepository.createClient(client);
        }
    }


    @Override
    public List<Client> getAllClient() {
        List<Client> clientList = clienteRepository.getAllClient();
        return clientList;
    }

    @Override
    public Client getClientById(Long id) throws Exception {
        Client oneClient = clienteRepository.getClientById(id);
        return oneClient;
    }


}
