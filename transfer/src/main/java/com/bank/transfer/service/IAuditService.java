package com.bank.transfer.service;

import com.bank.transfer.entity.Audit;

import java.util.List;

public interface IAuditService {
    Audit getAudit(Long id);

    List<Audit> getAllEntitiesAudit();

    void saveAudit(Audit audit);
}
