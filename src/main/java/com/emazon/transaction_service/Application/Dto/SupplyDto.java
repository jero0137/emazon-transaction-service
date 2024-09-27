package com.emazon.transaction_service.Application.Dto;

import com.emazon.transaction_service.Utils.Constant;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SupplyDto {
    @NotNull(message = Constant.ID_NOT_NULL_MESSAGE)
    @Min(value = 1, message = Constant.ID_NOT_NEGATIVE_MESSAGE)
    private Long productId;
    @Min(value = 1, message = Constant.QUANTITY_MIN_MESSAGE)
    private int quantity;
}
