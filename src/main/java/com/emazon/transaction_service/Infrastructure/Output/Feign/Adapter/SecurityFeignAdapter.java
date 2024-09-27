package com.emazon.transaction_service.Infrastructure.Output.Feign.Adapter;

import com.emazon.transaction_service.Domain.Spi.ISecurityFeignPort;
import org.springframework.stereotype.Service;

@Service
public class SecurityFeignAdapter implements ISecurityFeignPort {
    private static final ThreadLocal<String> tokenHolder = new ThreadLocal<>();

    @Override
    public void setToken(String token) {
        tokenHolder.set(token);
    }

    @Override
    public String getToken() {
        return tokenHolder.get();
    }

    @Override
    public void removeToken() {
        tokenHolder.remove();
    }
}
