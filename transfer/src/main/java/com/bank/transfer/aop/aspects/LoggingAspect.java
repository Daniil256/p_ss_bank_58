package com.bank.transfer.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Before(value = "execution(public * com.bank.transfer.controller.*Controller.* (..))")
    public void beforeGetAdvice(){
        System.out.println("будет выполнен");
    }
}
