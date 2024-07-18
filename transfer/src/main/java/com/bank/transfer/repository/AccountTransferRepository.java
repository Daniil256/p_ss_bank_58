package com.bank.transfer.repository;

import com.bank.transfer.entity.AccountTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.NotNull;

public interface AccountTransferRepository extends JpaRepository<AccountTransfer, Long> {
    @Query("from AccountTransfer a where a.accountNumber = :#{#num}")
    AccountTransfer findByAccountNumber(@NotNull @Param("num") Long accountNumber);
}
