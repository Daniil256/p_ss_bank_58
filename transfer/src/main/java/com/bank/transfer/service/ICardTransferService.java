package com.bank.transfer.service;

import com.bank.transfer.dto.CardTransferDto;
import com.bank.transfer.entity.CardTransfer;
import com.bank.transfer.exception.SQLTransferException;

public interface ICardTransferService {
    CardTransfer saveCardTransfer(CardTransferDto dto) throws SQLTransferException;

    CardTransfer editCardTransfer( CardTransferDto transfer,Long id) throws SQLTransferException;
}
