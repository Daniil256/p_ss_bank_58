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
@Table(name = "card_transfer", schema = "transfer")
public class CardTransfer {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
}