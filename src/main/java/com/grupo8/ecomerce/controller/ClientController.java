package com.grupo8.ecomerce.controller;


import com.grupo8.ecomerce.exceptions.OpsException;
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
     * @throws Exception
     */
    @GetMapping()
    public ResponseEntity<List<Client>> getAllClient() throws Exception {
      try {
          return ResponseEntity.ok(clientService.getAllClient());
      }catch (Exception e) {
          throw new Exception(e);
      }
    }

    /**
     * Este metodo retorna o estado/local do cliente
     * @param state
     * @return
     * @throws Exception
     */
    @GetMapping("/clientbystate/{state}")
    public ResponseEntity<List<Client>> getByState(@PathVariable String state) throws Exception {
        try {
            return ResponseEntity.ok(clientService.getByState(state));
        } catch (Exception e) {
            throw new OpsException();
        }
    }

    /**
     * Este metodo cria um novo cadastro de cliente
     * @param newClient
     * @throws Exception
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createClient(@RequestBody Client newClient) throws Exception {
        try {
            clientService.createClient(newClient);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Este metodo retorna uma lista de cliente por Id
     * @param id
     * @return
     * @throws Exception
     */

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClienteById(@PathVariable Long id) throws Exception {
        try {
            return ResponseEntity.ok(clientService.getClientById(id));
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
