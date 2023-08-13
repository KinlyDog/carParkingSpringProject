package com.kinlydog.carparking.repositoryes;

import com.kinlydog.carparking.models.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

    void deleteVehicleById(int id);

    Vehicle findVehicleById(int id);
}
