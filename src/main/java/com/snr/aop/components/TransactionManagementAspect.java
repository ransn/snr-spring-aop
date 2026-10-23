package com.snr.aop.components;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(4) // This will be executed fourth
public class TransactionManagementAspect {

    @Around("execution(* com.snr.aop.service.OrderService.*(..))")
    public Object manageTransaction(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Starting transaction for method "+joinPoint.getSignature().getName());
        try{
            Object result = joinPoint.proceed();
            System.out.println("Commiting Transaction.");
            return result;
        }catch (Exception ex){
            System.out.println("Rolling back transaction for method "+joinPoint.getSignature().getName());
            // Rethrowing same exception for the caller to handle.
            throw ex;
        }

    }
}
