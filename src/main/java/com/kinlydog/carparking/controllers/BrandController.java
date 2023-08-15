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

@Controller
public class BrandController {
    private final String TO_ADMIN;
    private final BrandDAO brandDAO;

    @Autowired
    public BrandController(BrandDAO brandDAO) {
        TO_ADMIN = "redirect:admin";
        this.brandDAO = brandDAO;
    }

    @GetMapping("/new-brand")
    String newBrand() {

        return "newBrand";
    }

    @PostMapping("/new-brand")
    String newBrandSave(@ModelAttribute Brand brand) {
        brandDAO.save(brand);

        return TO_ADMIN;
    }

    @PostMapping("/delete-brand")
    String deleteBrand(@RequestParam("id") int id) {
        brandDAO.delete(id);

        return TO_ADMIN;
    }
}
