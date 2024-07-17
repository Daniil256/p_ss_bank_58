package com.bank.transfer.aop;

import org.springframework.stereotype.Component;

@Component
public class AuditAop {
    public void handle(){
        System.out.println("прослушка");
    }
}
