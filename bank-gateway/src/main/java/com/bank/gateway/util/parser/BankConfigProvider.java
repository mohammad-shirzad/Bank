package com.bank.gateway.util.parser;

public class BankConfigProvider {
    private static BankConfigProvider bankConfigProvider = null;

    public static BankConfigProvider getInstance() {
        if (bankConfigProvider != null)
            return bankConfigProvider;
        synchronized (BankConfigProvider.class) {
            if (bankConfigProvider != null)
                return bankConfigProvider;
            return new BankConfigProvider();
        }
    }

    public String getBankName() {
        return "saman";
    }
}
