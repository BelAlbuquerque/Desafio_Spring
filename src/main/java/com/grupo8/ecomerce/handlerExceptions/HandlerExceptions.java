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
                        .title("Not Found")
                        .status(HttpStatus.NOT_FOUND.value())
                        .link("https://http.dog/404")
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
                        .link("https://http.cat/500")
                        .message(serverError.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IncorrectFields.class)
    public ResponseEntity<ErrorResponseDetails> handlerErrorBadRequest(IncorrectFields incorrectFields) {
        return new ResponseEntity<>(
                ErrorResponseDetails.builder()
                        .title("Bad Request")
                        .status(HttpStatus.BAD_REQUEST.value())
                        .link("https://http.dog/400")
                        .message(incorrectFields.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClientAlreadyExists.class)
    public ResponseEntity<ErrorResponseDetails> handlerErrorUnauthorized(ClientAlreadyExists clientAlreadyExists) {
        return new ResponseEntity<>(
                ErrorResponseDetails.builder()
                        .title("Unauthorized")
                        .status(HttpStatus.UNAUTHORIZED.value())
                        .link("https://http.cat/401")
                        .message(clientAlreadyExists.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(OpsException.class)
    public ResponseEntity<ErrorResponseDetails> handlerErrorOps(OpsException opsException) {
        return new ResponseEntity<>(
                ErrorResponseDetails.builder()
                        .title("Ops... algo imprevisto ocorreu!")
                        .status(HttpStatus.NOT_FOUND.value())
                        .link("https://http.cat/418")
                        .message("Algum erro imprevisto ocorreu,\n" +
                                " por favor entre em contato para que possamos para melhorarmos nossa API\n" +
                                "https://github.com/BelAlbuquerque/Desafio_Spring")
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.NOT_FOUND);
    }
}
