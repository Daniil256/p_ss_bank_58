package com.bank.transfer.controller;

import com.bank.transfer.dto.CardTransferDto;
import com.bank.transfer.entity.CardTransfer;
import com.bank.transfer.exception.EntityNotFoundException;
import com.bank.transfer.service.CardTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/card")
public class CardTransferController {

    private final CardTransferService service;

    @Autowired
    public CardTransferController(CardTransferService service) {
        this.service = service;
    }

    @PutMapping("/edit")
    public ResponseEntity<CardTransfer> editEntityCard(@RequestBody @Valid CardTransferDto transfer,
                                                       @RequestParam Long id) throws EntityNotFoundException {
        return new ResponseEntity<>(service.editCardTransfer(transfer,id), HttpStatus.CREATED);
    }

    @PostMapping("/save")
    public ResponseEntity<CardTransfer> addEntityCard(@RequestBody @Valid CardTransferDto transfer) {
        return new ResponseEntity<>(service.saveCardTransfer(transfer), HttpStatus.CREATED);
    }
}
