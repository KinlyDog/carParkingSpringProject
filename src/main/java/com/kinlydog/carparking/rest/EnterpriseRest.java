package com.kinlydog.carparking.rest;

import com.kinlydog.carparking.dao.EnterpriseRepository;
import com.kinlydog.carparking.dto.EnterpriseDTO;
import com.kinlydog.carparking.entity.Driver;
import com.kinlydog.carparking.entity.Enterprise;
import com.kinlydog.carparking.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EnterpriseRest {

    private final EnterpriseRepository enterpriseRepository;

    @Autowired
    public EnterpriseRest(EnterpriseRepository enterpriseRepository) {
        this.enterpriseRepository = enterpriseRepository;
    }

    @GetMapping("/enterprises")
    public List<EnterpriseDTO> getAllEnterprises() {
        List<Enterprise> enterprises = enterpriseRepository.findAll();

        return enterprises.stream()
                .map(enterprise -> {
                    EnterpriseDTO dto = new EnterpriseDTO();
                    dto.setId(enterprise.getId());
                    dto.setName(enterprise.getName());
                    dto.setCity(enterprise.getCity());

                    List<Integer> driverIds = enterprise.getDrivers().stream()
                            .map(Driver::getId)
                            .toList();

                    dto.setDrivers(driverIds.isEmpty() ? null : driverIds);


                    List<Integer> vehicleIds = enterprise.getVehicles().stream()
                            .map(Vehicle::getId)
                            .toList();

                    dto.setVehicles(vehicleIds.isEmpty() ? null : vehicleIds);


                    return dto;
                })
                .toList();
    }
}
