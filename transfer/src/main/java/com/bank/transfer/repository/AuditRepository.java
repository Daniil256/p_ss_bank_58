package com.bank.transfer.repository;

import com.bank.transfer.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.NotNull;

public interface AuditRepository extends JpaRepository<Audit, Long> {
    @Query("from Audit a where a.entityJson = :#{#entity}")
    Audit findByEntity(@NotNull @Param("entity") String entity);
}
