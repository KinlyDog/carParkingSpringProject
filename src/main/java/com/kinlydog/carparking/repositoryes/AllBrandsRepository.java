package com.kinlydog.carparking.repositoryes;

import com.kinlydog.carparking.models.AllBrands;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AllBrandsRepository extends CrudRepository<AllBrands, Integer> {

}
