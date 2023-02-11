package com.bank.domain.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ServiceAspects {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAspects.class);

    @Pointcut("execution(public * com.bank.service.*.* (..))")
    public void serviceIO() {
    }

    @Pointcut("execution(public void com.bank.service.*.* (..))")
    public void excluded() {
    }

    @Around(value = "serviceIO() && !excluded()")
    public Object insertAroundLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.info("invoking service: {}", proceedingJoinPoint.getSignature().getName());
        if (LOGGER.isDebugEnabled())
            LOGGER.debug("with parameters : {}", proceedingJoinPoint.getArgs()[0]);
        LOGGER.info(proceedingJoinPoint.getArgs()[0].toString());
        Object res = null;
        try {
            res = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            LOGGER.error("Service invocation results in following error: {}", e.getStackTrace());
        }
        LOGGER.info("exiting service: {}", proceedingJoinPoint.getSignature().getName());
        return res;
    }
}
