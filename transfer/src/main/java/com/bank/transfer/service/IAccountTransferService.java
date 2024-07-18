package com.bank.transfer.service;

import com.bank.transfer.dto.AccountTransferDto;
import com.bank.transfer.entity.AccountTransfer;
import com.bank.transfer.exception.SQLTransferException;

public interface IAccountTransferService {
    AccountTransfer saveAccountTransfer(AccountTransferDto dto) throws SQLTransferException;

    AccountTransfer editAccountTransfer( AccountTransferDto transfer,Long id) throws SQLTransferException;
}
