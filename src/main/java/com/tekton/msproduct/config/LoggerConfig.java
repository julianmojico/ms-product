package com.tekton.msproduct.config;

import lombok.Getter;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class LoggerConfig {

    @Getter
    private static final Logger logger = LoggerFactory.getLogger(LoggerConfig.class);

    @Before("execution(* com.tekton.msproduct.controller.*.*(..))")
    public void logBefore() {
        logger.info("Request received at: {}", System.currentTimeMillis());
    }

    @After("execution(* com.tekton.msproduct.controller.*.*(..))")
    public void logAfter() {
        logger.info("Request processed at: {}", System.currentTimeMillis());
    }
}