package com.bank.transfer.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "account_transfer", schema = "transfer")
public class AccountTransfer {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

}