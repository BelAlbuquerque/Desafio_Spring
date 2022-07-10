package com.grupo8.ecomerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class NotAllowed  extends RuntimeException {
    /**
     * Este método é um construtor da classe
     * @param message
     */
    public NotAllowed(String message) {
        super(message);
    }
}
