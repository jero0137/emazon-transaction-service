package com.emazon.transaction_service.Infrastructure.Output.Feign.Retreiver;

import com.emazon.transaction_service.Infrastructure.Output.Feign.Dto.ExceptionMessage;
import com.emazon.transaction_service.Infrastructure.Output.Feign.Exception.BadRequestException;
import com.emazon.transaction_service.Infrastructure.Output.Feign.Exception.InternalServerErrorException;
import com.emazon.transaction_service.Infrastructure.Output.Feign.Exception.NotFoundException;
import com.emazon.transaction_service.Utils.FeignConstant;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.io.InputStream;

public class RetreiveMessageErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        ExceptionMessage message = null;
        try (InputStream bodyIs = response.body()
                .asInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            message = mapper.readValue(bodyIs, ExceptionMessage.class);
        } catch (IOException e) {
            return new Exception(e.getMessage());
        }
        switch (response.status()) {
            case FeignConstant.BAD_REQUEST_CODE:
                return new BadRequestException(message != null ? message.getMessage() : FeignConstant.BAD_REQUEST);
            case FeignConstant.NOT_FOUND_CODE:
                return new NotFoundException(message != null ? message.getMessage() : FeignConstant.NOT_FOUND);
            default:
                return new InternalServerErrorException(
                        message != null ? message.getMessage() : FeignConstant.INTERNAL_SERVER_ERROR
                );
        }

    }
}