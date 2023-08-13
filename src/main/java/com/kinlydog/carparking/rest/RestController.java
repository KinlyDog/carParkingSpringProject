package com.kinlydog.carparking.rest;

import com.kinlydog.carparking.DTO.VehicleDTO;
import com.kinlydog.carparking.models.Vehicle;
import com.kinlydog.carparking.repositoryes.VehicleRepository;
import jakarta.persistence.EntityManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final VehicleRepository vehicleRepository;
    private final EntityManager entityManager;

    public RestController(VehicleRepository vehicleRepository, EntityManager entityManager) {
        this.vehicleRepository = vehicleRepository;
        this.entityManager = entityManager;
    }

    @GetMapping("/rest/getAllCars")
    public List<VehicleDTO> getAllVehicles() {
        List<Vehicle> vehicleList = (List<Vehicle>) vehicleRepository.findAll();

        return vehicleList.stream()
                .map(vehicle -> {
                    VehicleDTO dto = new VehicleDTO();
                    dto.setId(vehicle.getId());
                    dto.setYear(vehicle.getYear());
                    dto.setOdometer(vehicle.getOdometer());
                    dto.setColor(vehicle.getColor());
                    dto.setPrice(vehicle.getPrice());
                    dto.setBrandId(vehicle.getBrand().getId());

                    return dto;
                })
                .toList();
    }

    @GetMapping("/rest/test/{i}")
    public Vehicle getTest(@PathVariable("i") int i) {
        return entityManager.find(Vehicle.class, i);
    }


}
