package com.bank.transfer;

import com.bank.transfer.aop.AuditAop;
import com.bank.transfer.config.AopConfig;
import com.bank.transfer.controller.AccountTransferController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@Component
public class TransferApplication {
    public static void main(String[] args)  {
        SpringApplication.run(TransferApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

        AuditAop auditAop = context.getBean("auditAop", AuditAop.class);
        auditAop.handle();
        context.close();

    }
}
