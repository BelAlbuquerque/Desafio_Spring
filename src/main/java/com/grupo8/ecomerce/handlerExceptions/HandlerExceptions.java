package com.grupo8.ecomerce.handlerExceptions;

import com.grupo8.ecomerce.exceptions.ErrorResponseDetails;
import com.grupo8.ecomerce.exceptions.NotFoundProducts;
import com.grupo8.ecomerce.exceptions.ServerError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandlerExceptions {
    @ExceptionHandler(NotFoundProducts.class)
    public ResponseEntity<ErrorResponseDetails> handlerError(NotFoundProducts notFoundProducts) {
        return new ResponseEntity<>(
                ErrorResponseDetails.builder()
                        .title("Not Found Products")
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(notFoundProducts.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ServerError.class)
    public ResponseEntity<ErrorResponseDetails> handlerError(ServerError serverError) {
        return new ResponseEntity<>(
                ErrorResponseDetails.builder()
                        .title("Internal Server Error")
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(serverError.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
