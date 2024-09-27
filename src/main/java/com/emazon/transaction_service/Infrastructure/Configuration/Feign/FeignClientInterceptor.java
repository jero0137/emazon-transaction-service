package com.emazon.transaction_service.Infrastructure.Configuration.Feign;

import com.emazon.transaction_service.Domain.Spi.ISecurityFeignPort;
import com.emazon.transaction_service.Utils.Constant;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
public class FeignClientInterceptor implements RequestInterceptor{

    private final ISecurityFeignPort securityFeignAdapter;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String token = securityFeignAdapter.getToken();

        if(token != null){
            requestTemplate.header(Constant.AUTHORIZATION_HEADER, token);
        }
    }
}
