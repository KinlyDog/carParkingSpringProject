package com.kinlydog.carparking.rest;

import com.kinlydog.carparking.dao.BrandRepository;
import com.kinlydog.carparking.dto.BrandDTO;
import com.kinlydog.carparking.entity.Brand;
import com.kinlydog.carparking.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BrandRest {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandRest(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping("/brands")
    public List<BrandDTO> getAllBrands() {
        List<Brand> brands = brandRepository.findAll();

        return brands.stream()
                .map(brand -> {
                    BrandDTO dto = new BrandDTO();
                    dto.setId(brand.getId());
                    dto.setName(brand.getName());
                    dto.setType(brand.getType());
                    dto.setSafetyRating(brand.getSafetyRating());
                    dto.setSeatingCapacity(brand.getSeatingCapacity());
                    dto.setFuelCapacity(brand.getFuelCapacity());
                    dto.setAverageLKM(brand.getAverageLKM());

                    List<Integer> vehicleIds = brand.getVehicles().stream()
                            .map(Vehicle::getId)
                            .toList();

                    dto.setVehicles(vehicleIds.isEmpty() ? null : vehicleIds);

                    return dto;
                })
                .toList();
    }
}
