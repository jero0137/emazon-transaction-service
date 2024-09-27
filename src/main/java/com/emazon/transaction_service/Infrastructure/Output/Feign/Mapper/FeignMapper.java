package com.emazon.transaction_service.Infrastructure.Output.Feign.Mapper;

import com.emazon.transaction_service.Domain.Model.AddProductQuantity;
import com.emazon.transaction_service.Infrastructure.Output.Feign.Dto.AddProductQuantityDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeignMapper {
    AddProductQuantityDto ToSupplyFeignDto(AddProductQuantity addProductQuantity);
}
