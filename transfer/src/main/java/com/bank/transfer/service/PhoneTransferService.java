package com.bank.transfer.service;

import com.bank.transfer.entity.PhoneTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class PhoneTransferService implements IPhoneTransferService {

    private final EntityManager em;

    @Autowired
    public PhoneTransferService(EntityManager em) {
        this.em = em;
    }

    @Transactional
    @Override
    public PhoneTransfer getPhoneTransfer(Long id) {
        return em.createQuery("from PhoneTransfer p where p.id = :id", PhoneTransfer.class)
                .setParameter("id", id).getSingleResult();
    }

    @Transactional
    @Override
    public List<PhoneTransfer> getAllEntitiesPhone() {
        return em.createQuery("from PhoneTransfer", PhoneTransfer.class).getResultList();
    }

    @Transactional
    @Override
    public void savePhoneTransfer(PhoneTransfer transfer) {
        em.merge(transfer);
    }
}
