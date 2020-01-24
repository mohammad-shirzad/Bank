package com.bank.business.utility;

import java.text.DecimalFormat;

public class GeneratorUtil {
    private static final long MIN_PAN_VAL = 1000000000000000L;
    private static final long MAX_PAN_VAL = 9999999999999999L;
    private static final long MIN_CVV_VAL = 1000L;
    private static final long MAX_CVV_VAL = 9999L;

    public static String generateCardNo() {
        return new DecimalFormat("###.#####").format((Math.random() * ((MAX_PAN_VAL - MIN_PAN_VAL) + 1)) + MIN_PAN_VAL);
    }

    public static String generateCVV2() {
        return new DecimalFormat("###.#####").format((Math.random() * ((MAX_CVV_VAL - MIN_CVV_VAL) + 1)) + MIN_CVV_VAL);
    }
}
