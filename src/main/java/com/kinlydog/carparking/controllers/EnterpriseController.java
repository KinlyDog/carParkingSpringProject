package com.kinlydog.carparking.controllers;

import com.kinlydog.carparking.models.Brand;
import com.kinlydog.carparking.models.Enterprise;
import com.kinlydog.carparking.models.Vehicle;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EnterpriseController {
    private static final String REDIRECT_ADMIN_PANEL = "redirect:adminPanel";

    private final EntityManager entityManager;

    public EnterpriseController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @GetMapping("/addEnterprise")
    public String addEnterprise() {
        return "enterprise/addEnterprise.html";
    }

    @Transactional
    @PostMapping("/addEnterprise")
    public String addEnterpriseView(@ModelAttribute Enterprise enterprise) {

        entityManager.persist(enterprise);

        return REDIRECT_ADMIN_PANEL;
    }
}
