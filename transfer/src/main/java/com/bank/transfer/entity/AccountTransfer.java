package com.bank.transfer.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Entity
@Table(name = "account_transfer", schema = "transfer")
public class AccountTransfer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_transfer_id_gen")
    @SequenceGenerator(name = "account_transfer_id_gen", sequenceName = "account_transfer_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "account_number", nullable = false)
    private Long accountNumber;

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