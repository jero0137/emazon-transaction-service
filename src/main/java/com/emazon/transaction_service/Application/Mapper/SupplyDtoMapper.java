package com.emazon.transaction_service.Application.Mapper;

import com.emazon.transaction_service.Application.Dto.SupplyDto;
import com.emazon.transaction_service.Domain.Model.Supply;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplyDtoMapper {
    Supply toSupply(SupplyDto supplyDto);
}
