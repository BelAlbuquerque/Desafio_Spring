package com.grupo8.ecomerce.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@NoArgsConstructor
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServerError extends RuntimeException {
    /**
     * Este método é um construtor da classe
     * @param mensagem
     */
    public ServerError(String mensagem) {
        super(mensagem);
    }
}
