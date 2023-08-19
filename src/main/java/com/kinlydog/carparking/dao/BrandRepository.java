package com.kinlydog.carparking.dao;

import com.kinlydog.carparking.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
