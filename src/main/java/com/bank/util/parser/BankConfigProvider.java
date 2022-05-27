package com.bank.util.parser;

import com.bank.config.ApplicationConfig;

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
        return (String) ApplicationConfig.CONFIG_MAP.get("bank.name");
    }
}
