package com.kinlydog.carparking.controllers;

import com.kinlydog.carparking.dao.BrandRepository;
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
    private final BrandRepository brandRepository;

    @Autowired
    public BrandController(BrandRepository brandRepository) {
        TO_ADMIN = "redirect:admin";
        this.brandRepository = brandRepository;
    }

    @GetMapping("/new-brand")
    String newBrand() {

        return "newBrand";
    }

    @PostMapping("/new-brand")
    String newBrandSave(@ModelAttribute Brand brand) {
        brandRepository.save(brand);

        return TO_ADMIN;
    }

    @PostMapping("/delete-brand")
    String deleteBrand(@RequestParam("id") int id) {
        brandRepository.deleteById(id);

        return TO_ADMIN;
    }
}
