package com.kinlydog.carparking.repositoryes;

import com.kinlydog.carparking.models.Vehicle;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;


@Transactional
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

    void deleteVehicleById(int id);

    Vehicle findVehicleById(int id);

    Vehicle findVehicleByPrice(BigDecimal price);
}
