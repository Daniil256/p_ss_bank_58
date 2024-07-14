package com.bank.transfer.dto;

import com.bank.transfer.entity.PhoneTransfer;
import com.bank.transfer.service.PhoneTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PhoneTransferDto {
    private final PhoneTransferService service;

    @Autowired
    public PhoneTransferDto(PhoneTransferService service) {
        this.service = service;
    }

    public void addPhoneTransfer(PhoneTransfer transfer) {
        service.savePhoneTransfer(transfer);
    }

    public List<PhoneTransfer> listPhoneTransfer() {
        return service.getAllEntitiesPhone();
    }

    public PhoneTransfer getPhoneTransfer(Long id) {
        return service.getPhoneTransfer(id);
    }
}
