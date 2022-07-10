package com.grupo8.ecomerce.service;

import com.grupo8.ecomerce.exceptions.ClientAlreadyExists;
import com.grupo8.ecomerce.exceptions.IncorrectFields;
import com.grupo8.ecomerce.exceptions.NotFound;
import com.grupo8.ecomerce.model.Client;
import com.grupo8.ecomerce.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImp implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void createClient(Client client) {
        if (verifyDataClient(client)) {
            if (clientRepository.getClientById(client.getId()) == null) {
                clientRepository.createClient(client);
            } else {
                throw new ClientAlreadyExists("Cliente já cadastrado.");
            }
        } else {
            throw new IncorrectFields("Campos incorretos.");
        }
    }

    @Override
    public List<Client> getAllClient() {
        List<Client> clientList = clientRepository.getAllClient();
        if (clientList.size() < 1) throw new NotFound("nenhum cliente cadastrado");
        return clientList;
    }

    @Override
    public List<Client> getByState(String state) {
        List<Client> clientList = clientRepository.getAllClient();
        List<Client> filteredClientList = clientList.stream()
                .filter(client -> client.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());
        if(filteredClientList.size() < 1) throw new NotFound("Nenhum cliente encontrado");
        return  filteredClientList;
    }

    @Override
    public Client getClientById(Long id) {
        Client oneClient = clientRepository.getClientById(id);
        try {
            oneClient.getId();
        }catch (Exception e) {
            throw new NotFound("Cliente não encontrado.");
        }
        return oneClient;
    }

    private boolean verifyDataClient(Client client) {
        if (client.getId() == null) return false;
        if (client.getName() == null) return false;
        if (client.getCpf() == null) return false;
        if (client.getState() == null) return false;
        return true;
    }
}
