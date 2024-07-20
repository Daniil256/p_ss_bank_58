package com.bank.transfer.controller;

import com.bank.transfer.dto.AccountTransferDto;
import com.bank.transfer.entity.AccountTransfer;
import com.bank.transfer.exception.SQLTransferException;
import com.bank.transfer.service.AccountTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountTransferController {

    private final AccountTransferService service;

    @Autowired
    public AccountTransferController(AccountTransferService service) {
        this.service = service;
    }

    @PutMapping("/edit")
    public ResponseEntity<AccountTransfer> editEntityAccount(@RequestBody @Valid AccountTransferDto transfer,
                                                             @RequestParam Long id) throws SQLTransferException {
        return new ResponseEntity<>(service.editAccountTransfer(transfer, id), HttpStatus.CREATED);
    }

    @PostMapping("/save")
    public ResponseEntity<AccountTransfer> addEntityAccount(@RequestBody @Valid AccountTransferDto transfer) throws SQLTransferException {
        return new ResponseEntity<>(service.saveAccountTransfer(transfer), HttpStatus.CREATED);
    }
}
