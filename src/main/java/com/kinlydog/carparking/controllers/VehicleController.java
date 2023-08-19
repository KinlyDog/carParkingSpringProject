package com.kinlydog.carparking.controllers;

import com.kinlydog.carparking.dao.BrandRepository;
import com.kinlydog.carparking.dao.VehicleRepository;
import com.kinlydog.carparking.entity.Brand;
import com.kinlydog.carparking.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class VehicleController {
    private final String TO_ADMIN;

    private final VehicleRepository vehicleRepository;
    private final BrandRepository brandRepository;

    @Autowired
    public VehicleController(VehicleRepository vehicleRepository,
                             BrandRepository brandRepository) {

        this.TO_ADMIN = "redirect:admin";
        this.vehicleRepository = vehicleRepository;
        this.brandRepository = brandRepository;
    }

    @GetMapping("/new-vehicle")
    String newVehicle(Model model) {

        model.addAttribute("brands", brandRepository.findAll());

        return "newVehicle";
    }

    @PostMapping("/new-vehicle")
    String newVehicleSave(@ModelAttribute Vehicle vehicle,
                          @RequestParam("brandId") int brandId) {

        Brand b = brandRepository.findById(brandId).orElse(null);
        vehicle.setBrand(b);
        vehicleRepository.save(vehicle);

        return TO_ADMIN;
    }

    @PostMapping("/delete-vehicle")
    String deleteVehicle(@RequestParam("id") int id) {
        vehicleRepository.deleteById(id);

        return TO_ADMIN;
    }

    @GetMapping("/edit-vehicle")
    String editVehicle(@RequestParam("id") int vehicleId,
                       Model model) {

        Vehicle vehicle =
                vehicleRepository.findById(vehicleId).orElse(null);
        List<Brand> brands = brandRepository.findAll();
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("brands", brands);

        return "editVehicle";
    }

    @PostMapping("/edit-vehicle")
    String editVehicle(@ModelAttribute Vehicle vehicle,
                       @RequestParam("brandId") int brandId) {

        Brand brand = brandRepository.findById(brandId).orElse(null);
        vehicle.setBrand(brand);
        vehicleRepository.save(vehicle);

        return TO_ADMIN;
    }
}
