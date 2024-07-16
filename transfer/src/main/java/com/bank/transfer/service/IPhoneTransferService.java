package com.bank.transfer.service;

import com.bank.transfer.dto.PhoneTransferDto;
import com.bank.transfer.entity.PhoneTransfer;
import com.bank.transfer.exception.EntityNotFoundException;

public interface IPhoneTransferService {
    PhoneTransfer editPhoneTransfer(PhoneTransferDto transfer, Long id) throws EntityNotFoundException;

    PhoneTransfer savePhoneTransfer(PhoneTransferDto transfer);
}
