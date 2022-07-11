package com.grupo8.ecomerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFound extends RuntimeException {
    /**
     * Este método é um construtor da classe
     * @param mensagem
     */
    public NotFound(String mensagem) {
        super(mensagem);
    }
}
