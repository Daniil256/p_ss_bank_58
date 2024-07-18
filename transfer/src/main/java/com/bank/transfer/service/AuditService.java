package com.bank.transfer.service;

import com.bank.transfer.entity.Audit;
import com.bank.transfer.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AuditService implements IAuditService {
    private final AuditRepository repository;

    @Autowired
    public AuditService(AuditRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public void saveAudit(String transfer, String entityType) {
        Audit audit = Audit.build(0L, entityType, "transfer", "CreatedEntity",
                null, new Date().toInstant(), null, null, transfer);
        Audit requestEntity = repository.save(audit);
        System.out.println("Saved transfer " + requestEntity);
    }

    @Transactional
    @Override
    public void editAudit(String transfer, String entityType) {
        Audit audit = Audit.build(0L, entityType, "transfer", "Created",
                "Edited", new Date().toInstant(), new Date().toInstant(), transfer, transfer);
        Audit requestEntity = repository.save(audit);
        System.out.println("Updated transfer " + requestEntity);
    }
}