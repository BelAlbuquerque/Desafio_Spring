package com.grupo8.ecomerce.handlerExceptions;

import com.grupo8.ecomerce.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandlerExceptions {
    @ExceptionHandler(NotFound.class)
    public ResponseEntity<ErrorResponseDetails> handlerErrorNotFound(NotFound notFoundProducts) {
        return new ResponseEntity<>(
                ErrorResponseDetails.builder()
                        .title("Not Found Products")
                        .status(HttpStatus.NOT_FOUND.value())
                        .message(notFoundProducts.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ServerError.class)
    public ResponseEntity<ErrorResponseDetails> handlerErrorInternal(ServerError serverError) {
        return new ResponseEntity<>(
                ErrorResponseDetails.builder()
                        .title("Internal Server Error")
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(serverError.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IncorrectFields.class)
    public ResponseEntity<ErrorResponseDetails> handlerErrorBadRequest(ClientAlreadyExists serverError) {
        return new ResponseEntity<>(
                ErrorResponseDetails.builder()
                        .title("Bad Request")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .message(serverError.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClientAlreadyExists.class)
    public ResponseEntity<ErrorResponseDetails> handlerErrorUnauthorized(ServerError serverError) {
        return new ResponseEntity<>(
                ErrorResponseDetails.builder()
                        .title("Unauthorized")
                        .status(HttpStatus.UNAUTHORIZED.value())
                        .message(serverError.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.UNAUTHORIZED);
    }

}
