package com.common.utils.singleton;

import org.dozer.DozerBeanMapper;

public class DozerMapper {
    private static DozerBeanMapper dozerBeanMapper;

    private DozerMapper() {
    }

    public static DozerBeanMapper getDozerBeanMapper() {
        if (dozerBeanMapper == null)
            return new DozerBeanMapper();
        else
            return dozerBeanMapper;
    }
}
