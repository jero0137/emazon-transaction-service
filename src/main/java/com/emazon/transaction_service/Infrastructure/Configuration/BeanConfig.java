package com.emazon.transaction_service.Infrastructure.Configuration;

import com.emazon.transaction_service.Domain.Api.ISupplyServicePort;
import com.emazon.transaction_service.Domain.Spi.IProductPersistencePort;
import com.emazon.transaction_service.Domain.Spi.ISecurityFeignPort;
import com.emazon.transaction_service.Domain.Spi.ISupplyPersistencePort;
import com.emazon.transaction_service.Domain.UseCase.SupplyUseCase;
import com.emazon.transaction_service.Infrastructure.Output.Feign.Client.StockFeignClient;
import com.emazon.transaction_service.Infrastructure.Output.Feign.Mapper.FeignMapper;
import com.emazon.transaction_service.Infrastructure.Output.Feign.Adapter.ProductFeignAdapter;
import com.emazon.transaction_service.Infrastructure.Output.Feign.Adapter.SecurityFeignAdapter;
import com.emazon.transaction_service.Infrastructure.Output.Jpa.Adapter.SupplyAdapter;
import com.emazon.transaction_service.Infrastructure.Output.Jpa.Mapper.SupplyEntityMapper;
import com.emazon.transaction_service.Infrastructure.Output.Jpa.Repository.SupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfig {


    private final SupplyRepository supplyRepository;
    private final SupplyEntityMapper supplyEntityMapper;

    private final StockFeignClient stockFeignClient;
    private final FeignMapper feignMapper;

    @Bean
    public ISupplyPersistencePort supplyPersistencePort() {
        return new SupplyAdapter(supplyRepository, supplyEntityMapper);
    }

    @Bean
    public IProductPersistencePort productPersistencePort() {
        return new ProductFeignAdapter(stockFeignClient, feignMapper);
    }

    @Bean
    public ISupplyServicePort supplyServicePort() {
        return new SupplyUseCase(supplyPersistencePort(), productPersistencePort(), securityFeignPort());
    }

    @Bean
    public ISecurityFeignPort securityFeignPort() {
        return new SecurityFeignAdapter();
    }

}
