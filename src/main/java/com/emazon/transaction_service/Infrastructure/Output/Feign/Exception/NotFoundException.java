package com.emazon.transaction_service.Infrastructure.Output.Feign.Exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
