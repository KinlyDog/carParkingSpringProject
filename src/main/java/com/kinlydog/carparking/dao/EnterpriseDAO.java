package com.kinlydog.carparking.dao;

import com.kinlydog.carparking.entity.Enterprise;

import java.util.List;

public interface EnterpriseDAO {

    void save(Enterprise enterprise);

    List<Enterprise> findAll();

    Enterprise findById(Integer id);

    void delete(Integer id);
}
