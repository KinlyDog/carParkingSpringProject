package com.kinlydog.carparking.controllers;

import com.kinlydog.carparking.models.Vehicle;
import com.kinlydog.carparking.repositoryes.VehicleRepository;
import com.kinlydog.carparking.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class VehicleController {

    private final VehicleRepository vehicleRepository;
    private final VehicleService vehicleService;

    public VehicleController(
            VehicleRepository vehicleRepository, VehicleService vehicleService) {

        this.vehicleRepository = vehicleRepository;
        this.vehicleService = vehicleService;
    }

    @GetMapping("/home")
    public String allVehicle(Model model) {
        Iterable<Vehicle> vehicles = vehicleRepository.findAll();

        model.addAttribute("vehicles", vehicles);

        return "home.html";
    }

    @PostMapping("/deleteVehicle")
    public String deleteVehicle(
            @RequestParam int id) {

        System.out.println("Метод delete работает");

        vehicleRepository.deleteVehicleById(id);

        return "redirect:home";
    }

    @PostMapping("/addVehicle")
    public String addVehicle(
            @RequestParam int year,
            @RequestParam int odometer,
            @RequestParam String color,
            @RequestParam BigDecimal price) {

        System.out.println("Метод add работает");

        vehicleRepository.addVenicle(year, odometer, color, price);

        return "redirect:home";
    }

    @GetMapping("/test")
    public String test() {
        return "test.html";
    }
}
