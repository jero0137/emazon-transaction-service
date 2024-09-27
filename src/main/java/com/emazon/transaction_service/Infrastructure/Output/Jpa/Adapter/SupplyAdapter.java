package com.emazon.transaction_service.Infrastructure.Output.Jpa.Adapter;

import com.emazon.transaction_service.Domain.Model.Supply;
import com.emazon.transaction_service.Domain.Spi.ISupplyPersistencePort;
import com.emazon.transaction_service.Infrastructure.Output.Jpa.Entity.SupplyEntity;
import com.emazon.transaction_service.Infrastructure.Output.Jpa.Mapper.SupplyEntityMapper;
import com.emazon.transaction_service.Infrastructure.Output.Jpa.Repository.SupplyRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SupplyAdapter implements ISupplyPersistencePort {

    private final SupplyRepository supplyRepository;
    private final SupplyEntityMapper supplyEntityMapper;

    @Override
    public void addSupply(Supply supply) {
        SupplyEntity supplyEntity = supplyEntityMapper.toSupplyEntity(supply);
        supplyRepository.save(supplyEntity);
    }
}
