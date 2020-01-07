package com.bank.business.utility;

public class GeneratorUtil {
    private static final long MIN_PAN_VAL = 1111111111111111L;
    private static final long MAX_PAN_VAL = 9999999999999999L;

    public static String generateCardNo() {
        return String.valueOf((Math.random() * ((MAX_PAN_VAL - MIN_PAN_VAL) + 1)) + MIN_PAN_VAL);
    }
}
