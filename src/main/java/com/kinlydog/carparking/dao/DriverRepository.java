package com.kinlydog.carparking.dao;

import com.kinlydog.carparking.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
}
