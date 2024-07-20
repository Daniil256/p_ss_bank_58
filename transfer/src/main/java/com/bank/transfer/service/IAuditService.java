package com.bank.transfer.service;

import com.bank.transfer.exception.SQLTransferException;

public interface IAuditService {
    void saveAudit(String transaction, String en) throws SQLTransferException;

    void editAudit(String transfer, String entityType) throws SQLTransferException;
}
