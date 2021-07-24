package com.codegym;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Logger {
    @AfterThrowing(pointcut = "execution(public * com.codegym.service.customer.ICustomerService.*(..))",throwing = "e")
    public void log(JoinPoint joinPoint, Exception e){
        String className=joinPoint.getTarget().getClass().getSimpleName();
        String method=joinPoint.getSignature().getName();
        String args= Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[CMS] có lỗi xảy ra: %s.%s%s: %s", className,method,args,e.getMessage()));
    }
}
