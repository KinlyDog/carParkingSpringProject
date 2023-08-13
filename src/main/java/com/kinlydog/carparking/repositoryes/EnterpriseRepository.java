package com.kinlydog.carparking.repositoryes;

import com.kinlydog.carparking.models.Enterprise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EnterpriseRepository extends CrudRepository<Enterprise, Integer> {

}
