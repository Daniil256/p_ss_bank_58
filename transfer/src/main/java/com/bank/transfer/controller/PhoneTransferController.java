package com.bank.transfer.controller;

import com.bank.transfer.repository.PhoneTransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bank.transfer.entity.PhoneTransfer;

import java.util.List;

@RestController
@RequestMapping("/phone")
public class PhoneTransferController {

    private final PhoneTransferRepository repository;

    @Autowired
    public PhoneTransferController(PhoneTransferRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<PhoneTransfer>> getAllEntitiesPhone() {
        List<PhoneTransfer> list = List.of();
        repository.findAll().forEach(list::add);
        System.out.println("get-all");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/get")
    public ResponseEntity<PhoneTransfer> getEntityPhone(@RequestParam Long id) {
        PhoneTransfer transfer = repository.findById(id).get();
        System.out.println("get");
        return ResponseEntity.ok(transfer);
    }

    @PostMapping("/save")
    public ResponseEntity.BodyBuilder addEntityPhone(PhoneTransfer transfer) {
        repository.save(transfer);
        System.out.println("save");
        return ResponseEntity.ok();
    }
}
