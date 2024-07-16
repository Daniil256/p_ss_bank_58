package com.bank.transfer.service;

import com.bank.transfer.dto.AccountTransferDto;
import com.bank.transfer.entity.AccountTransfer;
import com.bank.transfer.exception.EntityNotFoundException;

public interface IAccountTransferService {
    AccountTransfer saveAccountTransfer(AccountTransferDto dto);

    AccountTransfer editAccountTransfer( AccountTransferDto transfer,Long id) throws EntityNotFoundException;
}
