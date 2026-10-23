package com.snr.aop.components;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// Exception handling
@Component
@Aspect
public class ExceptionAspect {

    @AfterThrowing(pointcut = "execution(* com.snr.aop.service.*.*(..))", throwing = "ex")
    public void handleException(JoinPoint joinPoint, Exception ex){
        System.out.println("Exception occurred while executing method: "+joinPoint.getSignature().getName());
        System.out.println("Exception message: "+ex.getMessage());
    }
}
