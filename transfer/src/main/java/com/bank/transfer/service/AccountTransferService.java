package com.bank.transfer.service;

import com.bank.transfer.dto.AccountTransferDto;
import com.bank.transfer.entity.AccountTransfer;
import com.bank.transfer.exception.SQLTransferException;
import com.bank.transfer.repository.AccountTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountTransferService implements IAccountTransferService {

    private final AccountTransferRepository repository;

    @Autowired
    public AccountTransferService(AccountTransferRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public AccountTransfer saveAccountTransfer(AccountTransferDto dto) throws SQLTransferException {
        AccountTransfer transfer = AccountTransfer.build(0L, dto.getAccountNumber(), dto.getAmount(), dto.getPurpose(), dto.getAccountDetailsId());
        if (repository.findByAccountNumber(dto.getAccountNumber()) == null) {
            return repository.save(transfer);
        } else {
            throw new SQLTransferException(String.
                    format("Card transfer с номером %s уже существует", dto.getAccountNumber()));
        }
    }

    @Transactional
    @Override
    public AccountTransfer editAccountTransfer(AccountTransferDto transfer, Long id) throws SQLTransferException {
        if (repository.findById(id).isEmpty()) {
            throw new SQLTransferException(String.format("Account transfer with id=%s not found", id));
        } else {
            return repository.save(AccountTransfer.build(id, transfer.getAccountNumber(), transfer.getAmount(), transfer.getPurpose(), transfer.getAccountDetailsId()));
        }
    }
}
