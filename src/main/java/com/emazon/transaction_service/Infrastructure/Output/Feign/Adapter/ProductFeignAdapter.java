package com.emazon.transaction_service.Infrastructure.Output.Feign.Adapter;

import com.emazon.transaction_service.Domain.Model.AddProductQuantity;
import com.emazon.transaction_service.Domain.Spi.IProductPersistencePort;
import com.emazon.transaction_service.Infrastructure.Output.Feign.Client.StockFeignClient;
import com.emazon.transaction_service.Infrastructure.Output.Feign.Dto.AddProductQuantityDto;
import com.emazon.transaction_service.Infrastructure.Output.Feign.Mapper.FeignMapper;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ProductFeignAdapter implements IProductPersistencePort {

    private final StockFeignClient productFeignClient;
    private final FeignMapper feignMapper;

    @Override
    public void addProductQuantity(AddProductQuantity addProductQuantity) {
        AddProductQuantityDto addProductQuantityDto = feignMapper.ToSupplyFeignDto(addProductQuantity);
        productFeignClient.supplyProduct(addProductQuantityDto);
    }
}
