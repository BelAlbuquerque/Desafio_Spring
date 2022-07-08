package com.grupo8.ecomerce.exceptions;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponseDetails {
    private String title;
    private int status;
    private String message;
    private LocalDateTime timestamp;
}
