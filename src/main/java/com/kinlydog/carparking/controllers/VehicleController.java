package com.kinlydog.carparking.controllers;

import com.kinlydog.carparking.dao.BrandDAO;
import com.kinlydog.carparking.dao.VehicleDAO;
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

    private final VehicleDAO vehicleDAO;
    private final BrandDAO brandDAO;

    @Autowired
    public VehicleController(VehicleDAO vehicleDAO, BrandDAO brandDAO) {
        TO_ADMIN = "redirect:admin";
        this.vehicleDAO = vehicleDAO;
        this.brandDAO = brandDAO;
    }

    @GetMapping("/new-vehicle")
    String newVehicle(Model model) {

        model.addAttribute("brands", brandDAO.findAll());

        return "newVehicle";
    }

    @PostMapping("/new-vehicle")
    String newVehicleSave(@ModelAttribute Vehicle vehicle,
                          @RequestParam("brandId") int brandId) {

        Brand b = brandDAO.findById(brandId);
        vehicle.setBrand(b);
        vehicleDAO.save(vehicle);

        return TO_ADMIN;
    }

    @PostMapping("/delete-vehicle")
    String deleteVehicle(@RequestParam("id") int id) {
        vehicleDAO.delete(id);

        return TO_ADMIN;
    }

    @GetMapping("/edit-vehicle")
    String editVehicle(@RequestParam("id") int vehicleId,
                       Model model) {

        Vehicle vehicle = vehicleDAO.findById(vehicleId);
        List<Brand> brands = brandDAO.findAll();
        model.addAttribute("vehicle", vehicle);
        model.addAttribute("brands", brands);

        return "editVehicle";
    }

    @PostMapping("/edit-vehicle")
    String editVehicle(@ModelAttribute Vehicle vehicle,
                       @RequestParam("brandId") int brandId) {

        Brand brand = brandDAO.findById(brandId);
        vehicle.setBrand(brand);
        vehicleDAO.update(vehicle);

        return TO_ADMIN;
    }
}
