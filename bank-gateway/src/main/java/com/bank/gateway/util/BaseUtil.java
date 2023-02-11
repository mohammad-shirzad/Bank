package com.bank.gateway.util;

public class BaseUtil {
    public static Long getNullableLong(String value) {
        return value == null ? null : Long.parseLong(value);
    }
}
