package com.kinlydog.carparking.rest;

import com.kinlydog.carparking.dao.DriverDAO;
import com.kinlydog.carparking.dto.DriverDTO;
import com.kinlydog.carparking.entity.Driver;
import com.kinlydog.carparking.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverRest {

    private final DriverDAO driverDAO;

    @Autowired
    public DriverRest(DriverDAO driverDAO) {
        this.driverDAO = driverDAO;
    }

    @GetMapping("/rest/all-drivers")
    public List<DriverDTO> getAllVehicles() {
        List<Driver> drivers = driverDAO.findAll();

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

                    List<Integer> vehicleIds = driver.getVehicles().stream()
                            .map(Vehicle::getId)
                            .toList();

                    dto.setVehicles(vehicleIds.isEmpty() ? null : vehicleIds);

                    return dto;
                })
                .toList();
    }
}
