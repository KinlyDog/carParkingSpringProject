package com.kinlydog.carparking.dao;


import com.kinlydog.carparking.entity.Brand;
import com.kinlydog.carparking.entity.Vehicle;

import java.util.List;

public interface VehicleDAO {

    void save(Vehicle vehicle);

    List<Vehicle> findAll();

    void delete(Integer id);

    Vehicle findById(Integer id);

    void update(Vehicle vehicle);
}
