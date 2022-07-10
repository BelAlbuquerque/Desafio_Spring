package com.grupo8.ecomerce.repository;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.grupo8.ecomerce.exceptions.NotFound;
import com.grupo8.ecomerce.exceptions.ServerError;
import com.grupo8.ecomerce.model.Client;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ClientRepository {

    private final String pathClient = "src/main/resources/client.json";

    /**
     * Este metodo está cadastrando um novo cliente
     * @param newClient
     */
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
            throw new ServerError("Erro Interno no Servidor.");
        }
    }

    /**
     *  Este metodo simula uma requisição de todos os clientes contidos no banco de dados
     * @return clientList
     */

    public List<Client> getAllClient() {
        ObjectMapper mapper = new ObjectMapper();
        List<Client> clientList = null;

        try {
            clientList = Arrays.asList(mapper.readValue(new File(pathClient), Client[].class));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ServerError("Erro Interno no Servidor.");
        }
        if(clientList.size() < 1) throw new NotFound("Não há clientes cadastrados.");

        return clientList;
    }

    /**
     *Este metodo simula uma requisicao de cliente por Id
     * @param id
     * @return client
     */

    public Client getClientById(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        Client client = null;

        try {
            List<Client> clientList = Arrays.asList(mapper.readValue(new File(pathClient), Client[].class));
            for (Client clienteExist : clientList) {
                if (clienteExist.getId().equals(id)) {
                    return client = clienteExist;
                }
            }
        } catch (Exception e) {
            throw new ServerError("Erro Interno no Servidor.");
        }
        return client;
    }
}
