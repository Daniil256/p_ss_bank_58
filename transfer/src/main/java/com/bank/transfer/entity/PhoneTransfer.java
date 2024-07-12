package com.bank.transfer.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "phone_transfer", schema = "transfer")
public class PhoneTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phone_transfer_id_gen")
    @SequenceGenerator(name = "phone_transfer_id_gen", sequenceName = "phone_transfer_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "phone_number", nullable = false)
    private Long phoneNumber;

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