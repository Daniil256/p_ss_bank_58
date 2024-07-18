package com.bank.transfer.service;

import com.bank.transfer.exception.SQLTransferException;
import org.springframework.transaction.annotation.Transactional;

public interface IAuditService {
    void saveAudit(String transaction) throws SQLTransferException;
    void findTransfer(Long id, String methodName) throws SQLTransferException;
    void editAudit(String transaction, String methodName) throws SQLTransferException;
}
