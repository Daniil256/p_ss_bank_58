package com.bank.transfer.service;

import com.bank.transfer.dto.PhoneTransferDto;
import com.bank.transfer.entity.PhoneTransfer;
import com.bank.transfer.exception.SQLTransferException;
import com.bank.transfer.repository.PhoneTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PhoneTransferService implements IPhoneTransferService {

    private final PhoneTransferRepository repository;

    @Autowired
    public PhoneTransferService(PhoneTransferRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public PhoneTransfer savePhoneTransfer(PhoneTransferDto dto) {
        PhoneTransfer transfer = PhoneTransfer.build(0L, dto.getPhoneNumber(), dto.getAmount(), dto.getPurpose(), dto.getAccountDetailsId());
        return repository.save(transfer);
    }

    @Transactional
    @Override
    public PhoneTransfer editPhoneTransfer(PhoneTransferDto transfer, Long id) throws SQLTransferException {
        if (repository.findById(id).isEmpty()) {
            throw new SQLTransferException(String.format("Phone transfer with id=%s not found", id));
        } else {
            return repository.save(PhoneTransfer.build(id, transfer.getPhoneNumber(), transfer.getAmount(), transfer.getPurpose(), transfer.getAccountDetailsId()));
        }
    }
}
