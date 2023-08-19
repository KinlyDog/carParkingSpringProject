package com.kinlydog.carparking.controllers;

import com.kinlydog.carparking.dao.BrandRepository;
import com.kinlydog.carparking.dao.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    private final BrandRepository brandRepository;
    private final VehicleRepository vehicleRepository;

    @Autowired
    public AdminController(
            BrandRepository brandRepository,
            VehicleRepository vehicleRepository) {

        this.brandRepository = brandRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping({"/", "/admin"})
    String admin(Model model) {

        model.addAttribute("vehicles", vehicleRepository.findAll());
        model.addAttribute("brands", brandRepository.findAll());

        return "admin";
    }
}
