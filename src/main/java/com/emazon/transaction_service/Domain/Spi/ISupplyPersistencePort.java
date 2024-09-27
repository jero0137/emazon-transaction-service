package com.emazon.transaction_service.Domain.Spi;

import com.emazon.transaction_service.Domain.Model.Supply;

public interface ISupplyPersistencePort {
    void addSupply(Supply supply);
}
