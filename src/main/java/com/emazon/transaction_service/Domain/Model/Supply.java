package com.emazon.transaction_service.Domain.Model;

import java.time.LocalDateTime;

public class Supply {
    private LocalDateTime transactionDate;
    private Long productId;
    private Integer quantity;
    private Long performedByUserId;

    public Supply(Long performedByUserId, Integer quantity, Long productId, LocalDateTime transactionDate) {
        this.performedByUserId = performedByUserId;
        this.quantity = quantity;
        this.productId = productId;
        this.transactionDate = transactionDate;
    }

    public Supply() {
    }


    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getPerformedByUserId() {
        return performedByUserId;
    }

    public void setPerformedByUserId(Long performedByUserId) {
        this.performedByUserId = performedByUserId;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
