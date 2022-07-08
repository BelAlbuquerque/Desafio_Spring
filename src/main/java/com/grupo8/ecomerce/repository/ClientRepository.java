package com.grupo8.ecomerce.repository;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.grupo8.ecomerce.model.Client;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ClientRepository {

    private final String pathClient = "src/main/resources/client.json";

    public void createClient(Client newClient) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        List<Client> clientList = null;

        try {
            clientList = Arrays.asList(mapper.readValue(new File(pathClient), Client[].class));
            List<Client> copyListClient = new ArrayList<>(clientList);
            copyListClient.add(newClient);
            writer.writeValue(new File(pathClient), copyListClient);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Client> getAllClient() {
        ObjectMapper mapper = new ObjectMapper();
        List<Client> clientList = null;

        try {
            clientList = Arrays.asList(mapper.readValue(new File(pathClient), Client[].class));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return clientList;
    }

    public Client getClientById(Long id) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Client client = null;
        List<Client> clientsList = Arrays.asList(mapper.readValue(new File(pathClient), Client[].class));
        for (Client clienteExiste : clientsList) {
            if (clienteExiste.getId().equals(id)) {
                return client = clienteExiste;
            }
        }
        return client;
    }
}
