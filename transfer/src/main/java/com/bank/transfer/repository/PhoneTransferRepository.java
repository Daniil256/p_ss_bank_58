package com.bank.transfer.repository;

import com.bank.transfer.entity.PhoneTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.NotNull;

public interface PhoneTransferRepository extends JpaRepository<PhoneTransfer, Long> {
    @Query("from PhoneTransfer p where p.phoneNumber = :#{#number}")
    PhoneTransfer findByNumber(@NotNull @Param("number") Long number);
}
