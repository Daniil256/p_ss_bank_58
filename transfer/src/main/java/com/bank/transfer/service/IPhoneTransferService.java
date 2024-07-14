package com.bank.transfer.service;

import com.bank.transfer.entity.PhoneTransfer;

import java.util.List;

public interface IPhoneTransferService {
    PhoneTransfer getPhoneTransfer(Long id);

    List<PhoneTransfer> getAllEntitiesPhone();

    void savePhoneTransfer(PhoneTransfer transfer);
}
