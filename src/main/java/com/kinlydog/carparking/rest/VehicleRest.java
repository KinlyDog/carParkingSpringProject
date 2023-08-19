package com.kinlydog.carparking.rest;

import com.kinlydog.carparking.dao.VehicleRepository;
import com.kinlydog.carparking.dto.VehicleDTO;
import com.kinlydog.carparking.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class VehicleRest {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleRest(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping("/vehicles")
    public List<VehicleDTO> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();

        return vehicles.stream()
                .map(vehicle -> {
                    VehicleDTO dto = new VehicleDTO();
                    dto.setId(vehicle.getId());
                    dto.setYear(vehicle.getYear());
                    dto.setOdometer(vehicle.getOdometer());
                    dto.setColor(vehicle.getColor());
                    dto.setPrice(vehicle.getPrice());

                    if (vehicle.getBrand() != null) {
                        dto.setBrandId(vehicle.getBrand().getId());
                    }

                    if (vehicle.getActiveDriver() != null) {
                        dto.setActiveDriverId(vehicle.getActiveDriver().getId());
                    }

                    if (vehicle.getEnterprise() != null) {
                        dto.setEnterpriseId(vehicle.getEnterprise().getId());
                    }

                    Set<Integer> driverIds = vehicle.getDriverAssignments()
                            .stream()
                            .map(assignment -> assignment.getDriver().getId())
                            .collect(Collectors.toSet());
                    dto.setDrivers(driverIds.isEmpty() ? null : driverIds);
                    return dto;
                })
                .toList();
    }
}
