package com.grupo8.ecomerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ClientAlreadyExists extends RuntimeException {
    public ClientAlreadyExists(String mensagem) {
        super(mensagem);
    }
}