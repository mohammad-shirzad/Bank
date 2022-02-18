package com.bank.util;

public class BaseUtil {
    public static Long getNullableLong(String value) {
        return value == null ? null : Long.parseLong(value);
    }
}
