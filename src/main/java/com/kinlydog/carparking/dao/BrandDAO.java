package com.kinlydog.carparking.dao;

import com.kinlydog.carparking.entity.Brand;

import java.util.List;

public interface BrandDAO {

    void save(Brand vehicle);

    List<Brand> findAll();

    Brand findById(Integer id);

    void delete(Integer id);
}
