package com.grupo8.ecomerce.handlerExceptions;

import com.grupo8.ecomerce.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandlerExceptions {

    /**
     * Este método retorna o Status Code NOT FOUND para o cliente
     * @param notFoundProducts
     * @return
     */
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

    /**
     * Este método retorna o Status Code INTERNAL SERVER ERROR para o cliente
     * @param serverError
     * @return
     */
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

    /**
     * Este método retorna o Status Code BAD REQUEST para o cliente
     * @param incorrectFields
     * @return
     */
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

    /**
     * Este método retorna o Status Code UNAUTHORIZED para o cliente
     * @param clientAlreadyExists
     * @return
     */
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

    /**
     * Este método retorna o Status Code UNAUTHORIZED para o cliente
     * @param notAllowed
     * @return
     */
    @ExceptionHandler(NotAllowed.class)
    public ResponseEntity<ErrorResponseDetails> handlerErrorNotAllowed(NotAllowed notAllowed) {
        return new ResponseEntity<>(
                ErrorResponseDetails.builder()
                        .title("Unauthorized")
                        .status(HttpStatus.UNAUTHORIZED.value())
                        .link("https://http.cat/401")
                        .message(notAllowed.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build(), HttpStatus.UNAUTHORIZED);
    }
}
