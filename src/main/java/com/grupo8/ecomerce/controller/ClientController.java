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
    private ClientService clienteService;

    @PostMapping
    public ResponseEntity createClient(@RequestBody Client newClient) {
        try{
            clienteService.createClient(newClient);
            return new ResponseEntity(null, HttpStatus.CREATED);
        }catch (Exception e){

        }
        return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    }

}
