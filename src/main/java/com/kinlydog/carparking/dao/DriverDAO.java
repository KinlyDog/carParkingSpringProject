package com.kinlydog.carparking.dao;

import com.kinlydog.carparking.entity.Driver;

import java.util.List;

public interface DriverDAO {

    void save(Driver driver);

    List<Driver> findAll();

    void delete(Integer id);

    Driver findById(Integer id);
}
