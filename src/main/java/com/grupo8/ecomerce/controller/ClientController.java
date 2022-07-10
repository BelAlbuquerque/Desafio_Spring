package com.grupo8.ecomerce.controller;


import com.grupo8.ecomerce.model.Client;
import com.grupo8.ecomerce.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     * Este metodo retorna uma lista com todos os clientes
     * @return
     */
    @GetMapping()
    public ResponseEntity<List<Client>> getAllClient() {
        return ResponseEntity.ok(clientService.getAllClient());
    }

    /**
     * Este metodo retorna o estado/local do cliente
     * @param state
     * @return
     */
    @GetMapping("/clientbystate/{state}")
    public ResponseEntity<List<Client>> getByState(@PathVariable String state) {
        return ResponseEntity.ok(clientService.getByState(state));
    }

    /**
     * Este metodo cria um novo cadastro de cliente
     * @param newClient
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createClient(@RequestBody Client newClient) {
        clientService.createClient(newClient);
    }

    /**
     * Este metodo retorna uma lista de cliente por Id
     * @param id
     * @return
     */

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClienteById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }
}
