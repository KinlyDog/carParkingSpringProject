package com.kinlydog.carparking.rest;

import com.kinlydog.carparking.DTO.VehicleDTO;
import com.kinlydog.carparking.models.Vehicle;
import com.kinlydog.carparking.repositoryes.VehicleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final VehicleRepository vehicleRepository;

    public RestController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
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


}
