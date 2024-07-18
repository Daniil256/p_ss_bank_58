package com.bank.transfer.repository;

import com.bank.transfer.entity.CardTransfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.NotNull;

public interface CardTransferRepository extends JpaRepository<CardTransfer, Long> {
    @Query("from CardTransfer c where c.cardNumber = :#{#number}")
    CardTransfer findByNumber(@NotNull @Param("number") Long number);
}
