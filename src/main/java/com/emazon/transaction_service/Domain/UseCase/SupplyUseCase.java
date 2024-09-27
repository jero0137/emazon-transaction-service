package com.emazon.transaction_service.Domain.UseCase;

import com.emazon.transaction_service.Domain.Api.ISupplyServicePort;
import com.emazon.transaction_service.Domain.Model.AddProductQuantity;
import com.emazon.transaction_service.Domain.Model.Supply;
import com.emazon.transaction_service.Domain.Spi.IProductPersistencePort;
import com.emazon.transaction_service.Domain.Spi.ISecurityFeignPort;
import com.emazon.transaction_service.Domain.Spi.ISupplyPersistencePort;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SupplyUseCase implements ISupplyServicePort {
    private ISupplyPersistencePort supplyPersistencePort;
    private IProductPersistencePort productPersistencePort;
    private ISecurityFeignPort securityFeignPort;

    public SupplyUseCase(ISupplyPersistencePort supplyPersistencePort, IProductPersistencePort productPersistencePort, ISecurityFeignPort securityFeignPort) {
        this.supplyPersistencePort = supplyPersistencePort;
        this.productPersistencePort = productPersistencePort;
        this.securityFeignPort = securityFeignPort;
    }

    @Override
    public void addSupply(Supply supply, String token) {

        try{

            supply.setTransactionDate(LocalDateTime.now());

            securityFeignPort.setToken(token);

            AddProductQuantity addProductQuantity = new AddProductQuantity(supply.getProductId(), supply.getQuantity());


            productPersistencePort.addProductQuantity(addProductQuantity);
            supplyPersistencePort.addSupply(supply);
        }catch (Exception e){
            securityFeignPort.removeToken();
            throw e;
        }

    }


}
