package com.kinlydog.carparking.daoImpl;

import com.kinlydog.carparking.dao.VehicleDAO;
import com.kinlydog.carparking.entity.Brand;
import com.kinlydog.carparking.entity.Vehicle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class VehicleImpl implements VehicleDAO {

    private final EntityManager entityManager;

    @Autowired
    public VehicleImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Vehicle vehicle) {
        entityManager.persist(vehicle);
    }

    @Override
    public List<Vehicle> findAll() {

        TypedQuery<Vehicle> theQuery =
                entityManager.createQuery("FROM Vehicle", Vehicle.class);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Vehicle vehicle = entityManager.find(Vehicle.class, id);

        entityManager.remove(vehicle);
    }

    @Override
    public Vehicle findById(Integer id) {
        return entityManager.find(Vehicle.class, id);
    }

    @Override
    @Transactional
    public void update(Vehicle vehicle) {
        entityManager.merge(vehicle);
    }
}
