package com.example.aopspring.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

/*
    @Before("com.example.aopspring.aspects.CommonPointCutConfig.allPackagePackageUsingBean()")
    public void logMethodAllBeforeExection(JoinPoint joinPoint){

        logger.error("Before Aspect - {} est executé ", joinPoint);

    }

   @After("com.example.aopspring.aspects.CommonPointCutConfig.businessPackageConfig()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint){

        logger.info("After Aspect - {} est executé ", joinPoint.getSignature());
        logger.info("After Aspect - Le ou les paramètres de la methode : {} ", joinPoint.getArgs());


    }

    @AfterReturning(pointcut = "com.example.aopspring.aspects.CommonPointCutConfig.dataPackageConfig()", returning = "resultValue")
    public void logMethodCallAfterSuccessExecution(JoinPoint joinPoint, Object resultValue ){

        logger.debug("AfterReturning Aspect - le retour des methodes est : {}", resultValue);


    }*/





}
