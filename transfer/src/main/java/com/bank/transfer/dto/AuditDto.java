package com.bank.transfer.dto;

import com.bank.transfer.entity.Audit;
import com.bank.transfer.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuditDto {
    private final AuditService service;

    @Autowired
    public AuditDto(AuditService service) {
        this.service = service;
    }

    public void addAudit(Audit audit) {
        service.saveAudit(audit);
    }

    public List<Audit> listAudit() {
        return service.getAllEntitiesAudit();
    }

    public Audit getAudit(Long id) {
        return service.getAudit(id);
    }
}
