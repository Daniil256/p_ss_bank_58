package com.bank.transfer.service;

import com.bank.transfer.dto.PhoneTransferDto;
import com.bank.transfer.entity.PhoneTransfer;
import com.bank.transfer.exception.SQLTransferException;

public interface IPhoneTransferService {
    PhoneTransfer editPhoneTransfer(PhoneTransferDto transfer, Long id) throws SQLTransferException;

    PhoneTransfer savePhoneTransfer(PhoneTransferDto transfer) throws SQLTransferException;
}
