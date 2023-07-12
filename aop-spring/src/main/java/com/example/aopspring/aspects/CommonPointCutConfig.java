package com.example.aopspring.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointCutConfig {

    @Pointcut("execution(* com.example.aopspring.*.*.*(..))")
    public void demoAndDataPackageConfig(){}

    @Pointcut("execution(* com.example.aopspring.business.*.*(..))")
    public void businessPackageConfig(){}

    @Pointcut("execution(* com.example.aopspring.data.*.*(..))")
    public void dataPackageConfig(){}

    @Pointcut("bean(*Service*)")
    public void allPackagePackageUsingBean(){}


    @Pointcut("@annotation(com.example.aopspring.annotations.TrackTime)")
    public void trackTimeAnnotation(){}


}