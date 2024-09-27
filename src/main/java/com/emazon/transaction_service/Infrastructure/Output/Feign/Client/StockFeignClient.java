package com.emazon.transaction_service.Infrastructure.Output.Feign.Client;


import com.emazon.transaction_service.Infrastructure.Configuration.Feign.FeignClientConfig;
import com.emazon.transaction_service.Infrastructure.Output.Feign.Dto.AddProductQuantityDto;
import com.emazon.transaction_service.Utils.FeignConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "stock-service", url = FeignConstant.URL_STOCK_SERVICE, configuration = FeignClientConfig.class)
public interface StockFeignClient {
    @PatchMapping(FeignConstant.URL_STOCK_SERVICE_UPDATE_QUANTITY)
    ResponseEntity<Void> supplyProduct(@RequestBody AddProductQuantityDto supplyDto);
}
