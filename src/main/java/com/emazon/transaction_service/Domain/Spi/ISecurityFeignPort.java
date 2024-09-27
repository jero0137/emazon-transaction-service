package com.emazon.transaction_service.Domain.Spi;

public interface ISecurityFeignPort {
    public void setToken(String token);
    public String getToken();
    public void removeToken();
}
