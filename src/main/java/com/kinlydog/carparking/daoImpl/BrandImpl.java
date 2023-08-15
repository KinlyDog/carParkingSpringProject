package com.kinlydog.carparking.daoImpl;

import com.kinlydog.carparking.dao.BrandDAO;
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
public class BrandImpl implements BrandDAO {

    private final EntityManager entityManager;
    private final VehicleDAO vehicleDAO;

    @Autowired
    public BrandImpl(EntityManager entityManager, VehicleDAO vehicleDAO) {

        this.entityManager = entityManager;
        this.vehicleDAO = vehicleDAO;
    }

    @Override
    @Transactional
    public void save(Brand vehicle) {
        entityManager.persist(vehicle);
    }

    @Override
    public List<Brand> findAll() {

        TypedQuery<Brand> theQuery =
                entityManager.createQuery("FROM Brand", Brand.class);

        return theQuery.getResultList();
    }

    @Override
    public Brand findById(Integer id) {
        return entityManager.find(Brand.class, id);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        List<Vehicle> vehicles = vehicleDAO.findAll();

        for (Vehicle v : vehicles) {
            int brandId = v.getBrand().getId();

            if (brandId == id) {
                vehicleDAO.delete(v.getId());
            }
        }

        Brand brand = entityManager.find(Brand.class, id);

        entityManager.remove(brand);
    }
}
