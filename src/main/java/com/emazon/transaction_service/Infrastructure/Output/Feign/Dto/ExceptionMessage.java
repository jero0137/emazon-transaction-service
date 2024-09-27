package com.emazon.transaction_service.Infrastructure.Output.Feign.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ExceptionMessage {
    @JsonProperty("Message")
    private String message;
}