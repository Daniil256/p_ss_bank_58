package com.bank.transfer.aop.aspects;

import com.bank.transfer.exception.SQLTransferException;
import com.bank.transfer.service.AuditService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    private final AuditService service;

    @Autowired
    public LoggingAspect(AuditService service) {
        this.service = service;
    }

    @AfterReturning("execution(public * com.bank.transfer.controller.*Controller.add* (..))")
    public void saveAudit(JoinPoint joinPoint) throws SQLTransferException {
        service.saveAudit(joinPoint.getArgs()[0].toString());
    }

    @Before("execution(public * com.bank.transfer.controller.*Controller.edit* (..))")
    public void findTransfer(JoinPoint joinPoint) throws SQLTransferException {
        service.findTransfer((Long) joinPoint.getArgs()[1], joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(public * com.bank.transfer.controller.*Controller.edit* (..))")
    public void editAudit(JoinPoint joinPoint) throws SQLTransferException {
        service.editAudit(joinPoint.getArgs()[0].toString(), joinPoint.getSignature().getName());
    }
}
