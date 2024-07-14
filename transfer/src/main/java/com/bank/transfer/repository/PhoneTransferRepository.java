package com.bank.transfer.repository;

import com.bank.transfer.entity.PhoneTransfer;
import io.micrometer.core.lang.NonNullApi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@NonNullApi
@Repository
public interface PhoneTransferRepository extends CrudRepository<PhoneTransfer, Long> {
    Optional<PhoneTransfer> findById(Long id);

    Iterable<PhoneTransfer> findAll();

    <S extends PhoneTransfer> S save(S transfer);
}
