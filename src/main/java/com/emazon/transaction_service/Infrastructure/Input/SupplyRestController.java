package com.emazon.transaction_service.Infrastructure.Input;


import com.emazon.transaction_service.Application.Dto.SupplyDto;
import com.emazon.transaction_service.Application.Handler.ISupplyHandler;
import com.emazon.transaction_service.Infrastructure.Output.Jpa.Entity.UserEntity;
import com.emazon.transaction_service.Utils.Constant;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/supply")
public class SupplyRestController {
    private final ISupplyHandler supplyHandler;


    @Operation(summary = "Supply a product", description = "Supply a product with the given details")
    @PostMapping("/")
    public ResponseEntity<Void> supplyProduct(@RequestBody SupplyDto supplyDto,
                                              @RequestHeader(Constant.AUTHORIZATION_HEADER) String token) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserEntity userDetail = (UserEntity) authentication.getPrincipal();
        Long userId = userDetail.getId();

        supplyHandler.supplyProduct(supplyDto, userId ,token);
        return ResponseEntity.ok().build();

    }

}
