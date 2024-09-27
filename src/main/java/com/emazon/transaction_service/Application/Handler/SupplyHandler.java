package com.emazon.transaction_service.Application.Handler;

import com.emazon.transaction_service.Application.Dto.SupplyDto;
import com.emazon.transaction_service.Application.Mapper.SupplyDtoMapper;
import com.emazon.transaction_service.Domain.Api.ISupplyServicePort;
import com.emazon.transaction_service.Domain.Model.Supply;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplyHandler  implements ISupplyHandler{

    private final ISupplyServicePort supplyServicePort;
    private final SupplyDtoMapper supplyDtoMapper;

    @Override
    public void supplyProduct(SupplyDto supplyDto, Long userId, String token) {
        Supply supply = supplyDtoMapper.toSupply(supplyDto);
        supply.setPerformedByUserId(userId);
        supplyServicePort.addSupply(supply, token);
    }
}
