package com.emazon.transaction_service.UseCaseTest;

import com.emazon.transaction_service.Domain.Api.ISupplyServicePort;
import com.emazon.transaction_service.Domain.Model.AddProductQuantity;
import com.emazon.transaction_service.Domain.Model.Supply;
import com.emazon.transaction_service.Domain.Spi.IProductPersistencePort;
import com.emazon.transaction_service.Domain.Spi.ISecurityFeignPort;
import com.emazon.transaction_service.Domain.Spi.ISupplyPersistencePort;
import com.emazon.transaction_service.Domain.UseCase.SupplyUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SupplyUseCaseTest {
    @Mock
    private ISupplyPersistencePort supplyPersistencePort;

    @Mock
    private IProductPersistencePort productPersistencePort;

    @Mock
    private ISecurityFeignPort securityFeignPort;

    @InjectMocks
    private SupplyUseCase supplyUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddSupply() {

        Supply supply = new Supply(1L, 10, 1L, null);
        String token = "valid-token";

        Mockito.doNothing().when(productPersistencePort).addProductQuantity(Mockito.any());

        Mockito.doNothing().when(supplyPersistencePort).addSupply(supply);

        supplyUseCase.addSupply(supply, token);

        Mockito.verify(securityFeignPort).setToken(token);

        Mockito.verify(supplyPersistencePort).addSupply(supply);

    }
}