package com.emazon.transaction_service.Domain.Model;

public class AddProductQuantity {
    private Long productId;
    private int quantity;

    public AddProductQuantity(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
