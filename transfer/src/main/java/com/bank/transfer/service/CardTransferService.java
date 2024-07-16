package com.bank.transfer.service;

import com.bank.transfer.dto.CardTransferDto;
import com.bank.transfer.entity.CardTransfer;
import com.bank.transfer.exception.EntityNotFoundException;
import com.bank.transfer.repository.CardTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardTransferService implements ICardTransferService {

    private final CardTransferRepository repository;

    @Autowired
    public CardTransferService(CardTransferRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public CardTransfer saveCardTransfer(CardTransferDto dto) {
        CardTransfer transfer = CardTransfer.build(0L, dto.getCardNumber(), dto.getAmount(), dto.getPurpose(), dto.getAccountDetailsId());
        return repository.save(transfer);
    }

    @Transactional
    @Override
    public CardTransfer editCardTransfer(CardTransferDto transfer, Long id) throws EntityNotFoundException {
        if (repository.findById(id).isEmpty()) {
            throw new EntityNotFoundException(String.format("Card transfer with id=%s not found", id));
        } else {
            return repository.save(CardTransfer.build(id, transfer.getCardNumber(), transfer.getAmount(), transfer.getPurpose(), transfer.getAccountDetailsId()));
        }
    }
}
