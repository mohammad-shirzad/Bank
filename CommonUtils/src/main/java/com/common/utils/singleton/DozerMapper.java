package com.common.utils.singleton;

import org.dozer.DozerBeanMapper;

import java.util.Arrays;

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
