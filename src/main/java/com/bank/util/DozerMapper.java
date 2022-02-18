package com.bank.util;

import org.dozer.DozerBeanMapper;

public class DozerMapper {
    private static DozerBeanMapper dozerBeanMapper;

    private DozerMapper() {
    }

    public static DozerBeanMapper getDozerBeanMapper() {
        if (dozerBeanMapper == null) {
            dozerBeanMapper = new DozerBeanMapper();
            return dozerBeanMapper;
        }
        else
            return dozerBeanMapper;
    }
}
