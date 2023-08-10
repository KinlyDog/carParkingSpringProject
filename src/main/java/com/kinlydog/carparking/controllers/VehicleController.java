package com.kinlydog.carparking.controllers;

import com.kinlydog.carparking.models.AllBrands;
import com.kinlydog.carparking.models.Brand;
import com.kinlydog.carparking.models.Vehicle;
import com.kinlydog.carparking.repositoryes.AllBrandsRepository;
import com.kinlydog.carparking.repositoryes.BrandRepository;
import com.kinlydog.carparking.repositoryes.VehicleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VehicleController {
    private static final String REDIRECT_ADMIN_PANEL = "redirect:adminPanel";

    private final VehicleRepository vehicleRepository;
    private final BrandRepository brandRepository;
    private final AllBrandsRepository allBrandsRepository;

    public VehicleController(
            VehicleRepository vehicleRepository,
            BrandRepository brandRepository,
            AllBrandsRepository allBrandsRepository) {

        this.vehicleRepository = vehicleRepository;
        this.brandRepository = brandRepository;
        this.allBrandsRepository = allBrandsRepository;
    }

    @GetMapping("/")
    public String localhost() {
        return "/home";
    }

    @GetMapping("/adminPanel")
    public String allVehicle(Model model) {
        Iterable<Vehicle> vehicles = vehicleRepository.findAll();
        Iterable<Brand> brands = brandRepository.findAll();

        model.addAttribute("vehicles", vehicles);
        model.addAttribute("brands", brands);

        return "adminPanel.html";
    }

    @GetMapping("/addVehicle")
    public String addVehicleView(Model model) {

        Iterable<AllBrands> brandsList = allBrandsRepository.findAll();
        model.addAttribute("brands", brandsList);

        return "addVehicle.html";
    }

    @PostMapping("/addVehicle")
    public String addVehicle(@ModelAttribute Vehicle vehicle,
                             @ModelAttribute Brand brand,
                             @RequestParam String name) {


        brandRepository.save(brand);
        vehicle.setBrand(brandRepository.findBrandByName(name));
        vehicleRepository.save(vehicle);

        return REDIRECT_ADMIN_PANEL;
    }

    @PostMapping("/deleteVehicle")
    public String deleteVehicle(
            @RequestParam int id) {

        vehicleRepository.findVehicleById(id);

        vehicleRepository.deleteVehicleById(id);

        return REDIRECT_ADMIN_PANEL;
    }

    @PostMapping("/changeVehicleView")
    public String changeVehicleView(@RequestParam int id,
                                    @ModelAttribute Vehicle vehicle,
                                    Model model) {

        Iterable<AllBrands> brandsList = allBrandsRepository.findAll();
        model.addAttribute("brands", brandsList);

        model.addAttribute("v", vehicleRepository.findVehicleById(id));

        return "changeVehicleView.html";
    }


    @PostMapping("/changeVehicle")
    public String changeVehicle(@ModelAttribute Vehicle vehicle,
                                @ModelAttribute Brand brand,
                                @RequestParam("idBrand") int idBrand) {
        brand.setId(idBrand);
        brandRepository.save(brand);
        vehicle.setBrand(brand);
        vehicleRepository.save(vehicle);

        return REDIRECT_ADMIN_PANEL;
    }
}
