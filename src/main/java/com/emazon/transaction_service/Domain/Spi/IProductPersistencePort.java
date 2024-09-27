package com.emazon.transaction_service.Domain.Spi;

import com.emazon.transaction_service.Domain.Model.AddProductQuantity;

public interface IProductPersistencePort {
    void addProductQuantity(AddProductQuantity addProductQuantity);
}
