package com.emazon.transaction_service.Infrastructure.Output.Jpa.Mapper;

import com.emazon.transaction_service.Domain.Model.Supply;
import com.emazon.transaction_service.Infrastructure.Output.Jpa.Entity.SupplyEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplyEntityMapper {
    SupplyEntity toSupplyEntity(Supply supply);
}