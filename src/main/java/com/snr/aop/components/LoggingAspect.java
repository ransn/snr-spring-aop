package com.snr.aop.components;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Before("execution(* com.snr.aop.service.OrderService.*(..))")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Before Method: "+joinPoint.getSignature().getName());
    }

    @After("execution(* com.snr.aop.service.OrderService.*(..))")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("After Method: "+joinPoint.getSignature().getName());
    }
}
