package com.common.utils.parser;

public class BankConfigProvider {
    private String bankName;
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
        return ConfigReader.getConfigFile().getProperty("bank.name");
    }
}
