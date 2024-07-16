package com.bank.transfer.controller;

import com.bank.transfer.dto.PhoneTransferDto;
import com.bank.transfer.exception.EntityNotFoundException;
import com.bank.transfer.service.PhoneTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bank.transfer.entity.PhoneTransfer;

import javax.validation.Valid;

@RestController
@RequestMapping("/phone")
public class PhoneTransferController {

    private final PhoneTransferService service;

    @Autowired
    public PhoneTransferController(PhoneTransferService service) {
        this.service = service;
    }

    @PutMapping("/edit")
    public ResponseEntity<PhoneTransfer> editEntityPhone(@RequestBody @Valid PhoneTransferDto transfer,@RequestParam Long id) throws EntityNotFoundException {
        return new ResponseEntity<>(service.editPhoneTransfer(transfer,id), HttpStatus.CREATED);
    }

    @PostMapping("/save")
    public ResponseEntity<PhoneTransfer> addEntityPhone(@RequestBody @Valid PhoneTransferDto transfer) {
        return new ResponseEntity<>(service.savePhoneTransfer(transfer), HttpStatus.CREATED);
    }
}
