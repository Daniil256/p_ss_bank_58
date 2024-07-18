package com.bank.transfer.service;

import com.bank.transfer.dto.PhoneTransferDto;
import com.bank.transfer.entity.AccountTransfer;
import com.bank.transfer.entity.Audit;
import com.bank.transfer.entity.CardTransfer;
import com.bank.transfer.entity.PhoneTransfer;
import com.bank.transfer.exception.SQLTransferException;
import com.bank.transfer.repository.AccountTransferRepository;
import com.bank.transfer.repository.AuditRepository;
import com.bank.transfer.repository.CardTransferRepository;
import com.bank.transfer.repository.PhoneTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AuditService implements IAuditService {

    private AccountTransfer accountTransfer;
    private CardTransfer cardTransfer;
    private PhoneTransfer phoneTransfer;
    private Audit oldAudit;

    private final AuditRepository repository;
    private final AccountTransferRepository accountTransferRepository;
    private final CardTransferRepository cardTransferRepository;
    private final PhoneTransferRepository phoneTransferRepository;


    @Autowired
    public AuditService(AuditRepository repository, AccountTransferRepository accountTransferRepository,
                        CardTransferRepository cardTransferRepository, PhoneTransferRepository phoneTransferRepository) {
        this.repository = repository;
        this.accountTransferRepository = accountTransferRepository;
        this.cardTransferRepository = cardTransferRepository;
        this.phoneTransferRepository = phoneTransferRepository;
    }

    @Transactional
    @Override
    public void saveAudit(String transaction) throws SQLTransferException {
        String entityType = transaction.replaceAll("\\(.*\\)", "");
        Audit audit = Audit.build(0L, entityType, "transfer", "CreatedEntity",
                null, new Date().toInstant(), null, null, transaction);
        try {
            Audit requestEntity = repository.save(audit);
            System.out.println("Saved transaction " + requestEntity);
        } catch (Exception e) {
            throw new SQLTransferException("Ошибка записи транзакции Audit " + audit.toString() + " " + e);
        }
    }

    @Transactional
    @Override
    public void findTransfer(Long id, String methodName) throws SQLTransferException {
        try {
            switch (methodName) {
                case "editEntityAccount" -> accountTransfer = accountTransferRepository.findById(id).get();
                case "editEntityCard" -> cardTransfer = cardTransferRepository.findById(id).get();
                case "editEntityPhone" -> phoneTransfer = phoneTransferRepository.findById(id).get();
                default -> throw new SQLTransferException("Unknown method");
            }
        } catch (Exception e) {
            throw new SQLTransferException(String.format("Transfer with id=%s not found", id));
        }


        PhoneTransferDto dto = PhoneTransferDto.build(phoneTransfer.getPhoneNumber(), phoneTransfer.getAmount(), phoneTransfer.getPurpose(), phoneTransfer.getAccountDetailsId());
        System.out.println(dto.toString());
        oldAudit = switch (methodName) {
            case "editEntityAccount" -> repository.findById(accountTransfer.getId()).get();
            case "editEntityCard" -> repository.findById(cardTransfer.getId()).get();
            case "editEntityPhone" -> repository.findById(phoneTransfer.getId()).get();
            default -> throw new SQLTransferException("Unknown method");
        };
        System.out.println("oldAudit " + oldAudit);

    }

    @Transactional
    @Override
    public void editAudit(String transaction, String methodName) throws SQLTransferException {

        Audit audit = Audit.build(oldAudit.getId(), oldAudit.getEntityType(), oldAudit.getOperationType(), oldAudit.getCreatedBy(),
                "Edited", oldAudit.getCreatedAt(), new Date().toInstant(), transaction,
                oldAudit.getNewEntityJson() == null ? oldAudit.getEntityJson() : oldAudit.getNewEntityJson());
        try {
            Audit requestEntity = repository.save(audit);
            System.out.println("Updated transaction " + requestEntity);
        } catch (Exception e) {
            throw new SQLTransferException(String.format("Ошибка записи транзакции Audit %s %s", audit.toString(), e));
        }
    }
}