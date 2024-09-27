package com.emazon.transaction_service.Infrastructure.Output.Feign.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddProductQuantityDto {
    private Long productId;
    private Integer quantity;
}
