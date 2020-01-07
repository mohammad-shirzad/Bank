package com.bank.business.utility;

public class FormatUtil {
    private static final String PAYMENT_APPLICATION_NUMBER_STD_FORMAT = "^\\d{4}\\.\\d{3}\\.\\d{8}\\.\\d{4}$";

    public static boolean isValidPaymentApplicationNumberFormat(String resource) {
        return resource.matches(PAYMENT_APPLICATION_NUMBER_STD_FORMAT);

    }
}
