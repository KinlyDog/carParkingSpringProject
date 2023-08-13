package com.kinlydog.carparking.repositoryes;

import com.kinlydog.carparking.models.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BrandRepository extends CrudRepository<Brand, Integer> {

    Brand findBrandByName(String name);

}
