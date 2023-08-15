package com.kinlydog.carparking.daoImpl;

import com.kinlydog.carparking.dao.EnterpriseDAO;
import com.kinlydog.carparking.entity.Enterprise;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EnterpriseImpl implements EnterpriseDAO {

    private final EntityManager entityManager;

    @Autowired
    public EnterpriseImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Enterprise enterprise) {
        entityManager.persist(enterprise);
    }

    @Override
    public List<Enterprise> findAll() {

        TypedQuery<Enterprise> theQuery =
                entityManager.createQuery("FROM Enterprise", Enterprise.class);

        return theQuery.getResultList();
    }

    @Override
    public Enterprise findById(Integer id) {
        return entityManager.find(Enterprise.class, id);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Enterprise enterprise = entityManager.find(Enterprise.class, id);

        entityManager.remove(enterprise);
    }
}
