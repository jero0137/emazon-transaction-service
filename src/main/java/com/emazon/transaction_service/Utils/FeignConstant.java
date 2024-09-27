package com.emazon.transaction_service.Utils;

public class FeignConstant {
    public static final String URL_STOCK_SERVICE = "http://localhost:8080";
    public static final String URL_STOCK_SERVICE_UPDATE_QUANTITY = "/product/supply";

    public static final int BAD_REQUEST_CODE = 400;
    public static final int NOT_FOUND_CODE = 404;

    public static final String BAD_REQUEST = "Bad Request";
    public static final String NOT_FOUND = "Not Found";
    public static final String INTERNAL_SERVER_ERROR = "Internal Server Error from remote service";
}
