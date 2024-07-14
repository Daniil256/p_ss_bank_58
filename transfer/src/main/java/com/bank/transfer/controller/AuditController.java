package com.bank.transfer.controller;

import com.bank.transfer.entity.Audit;
import com.bank.transfer.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditController {
    private final AuditRepository repository;

    @Autowired
    public AuditController(AuditRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/get-all1")
    public ResponseEntity<List<Audit>> getAllEntitiesAudit() {
        List<Audit> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        System.out.println("get-all");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/get1")
    public ResponseEntity<Audit> getEntityAudit(@RequestParam Long id) {
        Audit audit = repository.findById(id).get();
        System.out.println("get");
        return ResponseEntity.ok(audit);
    }

    @PostMapping("/save1")
    public ResponseEntity<String> addAudit(@RequestBody Audit audit) {
        System.out.println(audit);
        repository.save(audit);
//        System.out.println("save");
        return new ResponseEntity<>(audit.toString(), HttpStatus.OK);
    }
}
