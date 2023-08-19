package com.kinlydog.carparking.rest;

import com.kinlydog.carparking.dao.DriverRepository;
import com.kinlydog.carparking.dto.DriverDTO;
import com.kinlydog.carparking.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class DriverRest {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverRest(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @GetMapping("/drivers")
    public List<DriverDTO> getAllVehicles() {
        List<Driver> drivers = driverRepository.findAll();

        return drivers.stream()
                .map(driver -> {
                    DriverDTO dto = new DriverDTO();
                    dto.setId(driver.getId());
                    dto.setName(driver.getName());
                    dto.setAge(driver.getAge());
                    dto.setSalary(driver.getSalary());
                    dto.setEnterpriseId(driver.getEnterprise().getId());

                    if (driver.getActiveVehicle() != null) {
                        dto.setActiveVehicleId(driver.getActiveVehicle().getId());
                    }

                    Set<Integer> vehicleIds = driver.getVehicleAssignments()
                            .stream()
                            .map(assignment -> assignment.getVehicle().getId())
                            .collect(Collectors.toSet());
                    dto.setVehicles(vehicleIds.isEmpty() ? null : vehicleIds);

                    return dto;
                })
                .toList();
    }
}
