package com.kinlydog.carparking.rest;

import com.kinlydog.carparking.DTO.VehicleDTO;
import com.kinlydog.carparking.models.Enterprise;
import com.kinlydog.carparking.models.Vehicle;
import com.kinlydog.carparking.repositoryes.EnterpriseRepository;
import com.kinlydog.carparking.repositoryes.VehicleRepository;
import jakarta.persistence.EntityManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Iterator;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    private final VehicleRepository vehicleRepository;
    private final EnterpriseRepository enterpriseRepository;
    private final EntityManager entityManager;


    public RestController(
            VehicleRepository vehicleRepository,
            EnterpriseRepository enterpriseRepository,
            EntityManager entityManager) {

        this.vehicleRepository = vehicleRepository;
        this.enterpriseRepository = enterpriseRepository;
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

    @GetMapping("/rest/enterprise")
    public Iterable<Enterprise> getTest() {
        return enterpriseRepository.findAll();
    }



}
