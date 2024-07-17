package com.bank.transfer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class AccountTransferDto {
    @NotNull
    @Column(unique=true)
    private Long accountNumber;

    @NotNull
    private BigDecimal amount;

    private String purpose;

    @NotNull
    private Long accountDetailsId;
}
