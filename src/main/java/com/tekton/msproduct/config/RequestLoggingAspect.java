package com.tekton.msproduct.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RequestLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingAspect.class);

    @Before("execution(* com.tekton.msproduct.controller.*.*(..))")
    public void logBefore() {
        logger.info("Request received at: {}", System.currentTimeMillis());
    }

    @After("execution(* com.tekton.msproduct.controller.*.*(..))")
    public void logAfter() {
        logger.info("Request processed at: {}", System.currentTimeMillis());
    }
}