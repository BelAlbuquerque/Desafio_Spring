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

    @GetMapping()
    public ResponseEntity<List<Client>> getAllClient() {
        return ResponseEntity.ok(clientService.getAllClient());
    }

    @GetMapping("/clientbystate/{state}")
    public ResponseEntity<List<Client>> getByState(@PathVariable String state) {
        return ResponseEntity.ok(clientService.getByState(state));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createClient(@RequestBody Client newClient) throws Exception {
        clientService.createClient(newClient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClienteById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(clientService.getClientById(id));
    }
}
