package com.snr.aop.components;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3) //This will be executed third
public class PerformanceAspect {
    @Around("execution(* com.snr.aop.service.*.*(..))")
    public Object logPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        
        Object result = joinPoint.proceed(); // Proceed with the method execution

        long endTime = System.currentTimeMillis();

        System.out.println("Execution time of " + joinPoint.getSignature().getName() + " is " + (endTime - startTime) + " ms");
        
        return result;
    }
}
