package com.bank.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceAspects {
    private Logger logger = LoggerFactory.getLogger(ServiceAspects.class);

    @Around("execution(public * com.bank.serviceImpl.CustomerServiceImpl.*(..))")
    public Object insertAroundLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.debug("**********--invoking service: " + proceedingJoinPoint.getSignature().toString());
        logger.debug(proceedingJoinPoint.getArgs()[0].toString());
        Object res = proceedingJoinPoint.proceed();
        logger.debug("*********--exiting service: " + proceedingJoinPoint.getSignature().toString());
        return res;
    }
}
