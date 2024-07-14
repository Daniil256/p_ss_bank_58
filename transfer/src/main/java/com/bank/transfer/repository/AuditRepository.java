package com.bank.transfer.repository;

import com.bank.transfer.entity.Audit;
import io.micrometer.core.lang.NonNullApi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@NonNullApi
@Repository
public interface AuditRepository extends CrudRepository<Audit, Long> {
    Optional<Audit> findById(Long id);

    Iterable<Audit> findAll();

    <S extends Audit> S save(S transfer);
}
