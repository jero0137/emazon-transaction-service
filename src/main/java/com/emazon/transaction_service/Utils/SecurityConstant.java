package com.emazon.transaction_service.Utils;

public class SecurityConstant {

    private SecurityConstant() {
        throw new IllegalStateException("Utility class");
    }

    public static final String SECRET_KEY = "294A404E635266556A586E327235753878214125442A472D4B6150645367566B";
    public static final String ROLE_CLAIM = "role";
    public static final String ID_CLAIM = "id";

}
