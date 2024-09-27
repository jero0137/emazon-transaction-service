package com.emazon.transaction_service.Infrastructure.Output.Feign.Exception;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message) {
        super(message);
    }
}
