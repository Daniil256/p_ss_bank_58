package com.bank.transfer.service;

import com.bank.transfer.dto.CardTransferDto;
import com.bank.transfer.entity.CardTransfer;
import com.bank.transfer.exception.EntityNotFoundException;

public interface ICardTransferService {
    CardTransfer saveCardTransfer(CardTransferDto dto);

    CardTransfer editCardTransfer( CardTransferDto transfer,Long id) throws EntityNotFoundException;
}
