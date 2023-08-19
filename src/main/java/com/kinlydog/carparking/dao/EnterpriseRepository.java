package com.kinlydog.carparking.dao;

import com.kinlydog.carparking.entity.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseRepository extends JpaRepository<Enterprise, Integer> {
}
