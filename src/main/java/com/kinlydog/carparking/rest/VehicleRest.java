package com.kinlydog.carparking.rest;

import com.kinlydog.carparking.dao.VehicleDAO;
import com.kinlydog.carparking.dto.VehicleDTO;
import com.kinlydog.carparking.entity.Driver;
import com.kinlydog.carparking.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleRest {

    private final VehicleDAO vehicleDAO;

    @Autowired
    public VehicleRest(VehicleDAO vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }

    @GetMapping("/rest/all-vehicles")
    public List<VehicleDTO> getAllVehicles() {
        List<Vehicle> vehicles = vehicleDAO.findAll();

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

                    List<Integer> driverIds = vehicle.getDrivers().stream()
                            .map(Driver::getId)
                            .toList();

                    dto.setDrivers(driverIds.isEmpty() ? null : driverIds);

                    return dto;
                })
                .toList();
    }
}
