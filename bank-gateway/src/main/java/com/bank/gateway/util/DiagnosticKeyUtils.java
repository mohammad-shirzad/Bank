package com.bank.gateway.util;

public class DiagnosticKeyUtils {
    private static String diagKey;

    public static String getDiagKey() {
        return diagKey;
    }

    public static void setDiagKey(String diagKey) {
        DiagnosticKeyUtils.diagKey = diagKey;
    }
}
