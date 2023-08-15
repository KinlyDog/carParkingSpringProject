package com.kinlydog.carparking.daoImpl;

import com.kinlydog.carparking.dao.DriverDAO;
import com.kinlydog.carparking.entity.Driver;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DriverImpl implements DriverDAO {

    private final EntityManager entityManager;

    @Autowired
    public DriverImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Driver driver) {
        entityManager.persist(driver);
    }

    @Override
    public List<Driver> findAll() {

        TypedQuery<Driver> theQuery =
                entityManager.createQuery("FROM Driver", Driver.class);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Driver vehicle = entityManager.find(Driver.class, id);

        entityManager.remove(vehicle);
    }

    @Override
    public Driver findById(Integer id) {
        return entityManager.find(Driver.class, id);
    }
}
