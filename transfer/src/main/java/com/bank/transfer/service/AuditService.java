package com.bank.transfer.service;

import com.bank.transfer.entity.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class AuditService implements IAuditService {
    private final EntityManager em;

    @Autowired
    public AuditService(EntityManager em) {
        this.em = em;
    }

    @Transactional
    @Override
    public Audit getAudit(Long id) {
        return em.createQuery("from Audit a where a.id = :id", Audit.class)
                .setParameter("id", id).getSingleResult();
    }

    @Transactional
    @Override
    public List<Audit> getAllEntitiesAudit() {
        return em.createQuery("from Audit", Audit.class).getResultList();

    }

    @Transactional
    @Override
    public void saveAudit(Audit audit) {
        em.merge(audit);
    }
}
