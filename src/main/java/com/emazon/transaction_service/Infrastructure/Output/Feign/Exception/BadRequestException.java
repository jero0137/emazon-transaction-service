package com.emazon.transaction_service.Infrastructure.Output.Feign.Exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
