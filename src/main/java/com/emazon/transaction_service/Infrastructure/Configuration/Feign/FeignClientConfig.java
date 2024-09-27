package com.emazon.transaction_service.Infrastructure.Configuration.Feign;


import com.emazon.transaction_service.Infrastructure.Output.Feign.Adapter.SecurityFeignAdapter;
import com.emazon.transaction_service.Infrastructure.Output.Feign.Retreiver.RetreiveMessageErrorDecoder;
import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import feign.okhttp.OkHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
public class FeignClientConfig {

    private final SecurityFeignAdapter securityAdapter;

    @Bean
    Logger.Level feignLoggerLevel() {
        return  Logger.Level.FULL;
    }

    @Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignClientInterceptor(securityAdapter);
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new RetreiveMessageErrorDecoder();
    }
}
