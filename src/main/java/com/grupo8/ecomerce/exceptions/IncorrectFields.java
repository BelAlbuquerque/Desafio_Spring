package com.grupo8.ecomerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectFields extends RuntimeException {
    public IncorrectFields(String mensagem) {
        super(mensagem);
    }
}
