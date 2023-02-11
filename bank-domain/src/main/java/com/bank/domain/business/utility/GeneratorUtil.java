package com.bank.domain.business.utility;

public class GeneratorUtil {
    private static final long MIN_PAN_VAL = 10000000L;
    private static final long MAX_PAN_VAL = 99999999L;
    private static final long MIN_CVV_VAL = 1000L;
    private static final long MAX_CVV_VAL = 9999L;

    public static String generateCardNo(String bankName) {
        switch (bankName) {
            case "saman":
                return "62198610" + generateCardSerial();
            default:
                throw new IllegalArgumentException("undefined bank name");
        }
    }

    public static String generateCardSerial() {
        return String.valueOf(MIN_PAN_VAL + (long) (Math.random() * (MAX_PAN_VAL - MIN_PAN_VAL)));
    }

    public static String generateCVV2() {
        return String.valueOf(MIN_CVV_VAL + (long) (Math.random() * (MAX_CVV_VAL - MIN_CVV_VAL)));
    }

    public static String generatePin1() {
        return String.valueOf(MIN_CVV_VAL + (long) (Math.random() * (MAX_CVV_VAL - MIN_CVV_VAL)));
    }
}
