package com.grupo8.ecomerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class NotAllowed  extends RuntimeException {
    public NotAllowed(String message) {
        super(message);
    }
}
