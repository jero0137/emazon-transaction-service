package com.emazon.transaction_service.Utils;

public class Constant {

    private Constant() {
        throw new IllegalStateException("Utility class");
    }

    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_USER = "USER";
    public static final String ROLE_AUX_BODEGA = "AUX_BODEGA";

    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String BEARER = "Bearer ";

    public static final String ID_NOT_NULL_MESSAGE = "Id cannot be null";
    public static final String ID_NOT_NEGATIVE_MESSAGE = "Id cannot be negative";

    public static final String QUANTITY_MIN_MESSAGE = "Quantity cannot be less than 1";
}
