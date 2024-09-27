package com.emazon.transaction_service.Domain.Api;

import com.emazon.transaction_service.Domain.Model.Supply;

public interface ISupplyServicePort {
    void addSupply(Supply supply, String token);
}
