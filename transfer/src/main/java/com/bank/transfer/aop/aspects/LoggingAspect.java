package com.bank.transfer.aop.aspects;

import com.bank.transfer.service.AuditService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
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
    public void saveAudit(JoinPoint joinPoint) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(joinPoint.getArgs()[0]);
        String entityType = joinPoint.getArgs()[0].toString().replaceAll("\\(.*\\)", "");
        service.saveAudit(str, entityType);
    }

    @AfterReturning("execution(public * com.bank.transfer.controller.*Controller.edit* (..))")
    public void editAudit(JoinPoint joinPoint) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(joinPoint.getArgs()[0]);
        String entityType = joinPoint.getArgs()[0].toString().replaceAll("\\(.*\\)", "");
        service.editAudit(str, entityType);
    }
}
