package com.bank.transfer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Entity
@Table(name = "card_transfer", schema = "transfer")
public class CardTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_transfer_id_gen")
    @SequenceGenerator(name = "card_transfer_id_gen", sequenceName = "card_transfer_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "card_number", nullable = false)
    private Long cardNumber;

    @NotNull
    @Column(name = "amount", nullable = false, precision = 20, scale = 2)
    private BigDecimal amount;

    @Column(name = "purpose")
    @Type(type = "org.hibernate.type.TextType")
    private String purpose;

    @NotNull
    @Column(name = "account_details_id", nullable = false)
    private Long accountDetailsId;

}