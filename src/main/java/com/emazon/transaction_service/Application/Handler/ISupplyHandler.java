package com.emazon.transaction_service.Application.Handler;

import com.emazon.transaction_service.Application.Dto.SupplyDto;

public interface ISupplyHandler {
    void supplyProduct(SupplyDto supplyDto, Long userId, String token);
}
