package com.kinlydog.carparking.controllers;

import com.kinlydog.carparking.dao.BrandDAO;
import com.kinlydog.carparking.dao.VehicleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    private final BrandDAO brandDAO;
    private final VehicleDAO vehicleDAO;

    @Autowired
    public AdminController(BrandDAO brandDAO, VehicleDAO vehicleDAO) {
        this.brandDAO = brandDAO;
        this.vehicleDAO = vehicleDAO;
    }

    @GetMapping({"/", "/admin"})
    String admin(Model model) {

        model.addAttribute("vehicles", vehicleDAO.findAll());
        model.addAttribute("brands", brandDAO.findAll());

        return "admin";
    }
}
