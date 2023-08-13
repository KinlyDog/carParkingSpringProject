package com.kinlydog.carparking.controllers;

import com.kinlydog.carparking.models.Brand;
import com.kinlydog.carparking.models.Enterprise;
import com.kinlydog.carparking.models.Vehicle;
//import com.kinlydog.carparking.repositoryes.BrandRepository;
import com.kinlydog.carparking.repositoryes.AllBrandsRepository;
import com.kinlydog.carparking.repositoryes.BrandRepository;
import com.kinlydog.carparking.repositoryes.EnterpriseRepository;
import com.kinlydog.carparking.repositoryes.VehicleRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VehicleController {

    private static final String REDIRECT_ADMIN_PANEL = "redirect:adminPanel";

    private final VehicleRepository vehicleRepository;
    private final BrandRepository brandRepository;
    private final AllBrandsRepository allBrandsRepository;
    private final EnterpriseRepository enterpriseRepository;

    private final EntityManager entityManager;

    public VehicleController(
            VehicleRepository vehicleRepository,
            BrandRepository brandRepository,
            AllBrandsRepository allBrandsRepository,
            EnterpriseRepository enterpriseRepository,
            EntityManager entityManager) {

        this.vehicleRepository = vehicleRepository;
        this.brandRepository = brandRepository;
        this.allBrandsRepository = allBrandsRepository;
        this.entityManager = entityManager;
        this.enterpriseRepository = enterpriseRepository;
    }

    @GetMapping("/")
    public String localhost() {
        return "/homeAndVehicle/home";
    }

    @GetMapping("/adminPanel")
    public String allVehicle(Model model) {
        model.addAttribute("vehicles", vehicleRepository.findAll());
        model.addAttribute("enterprises", enterpriseRepository.findAll());

        return "homeAndVehicle/adminPanel.html";
    }

    @GetMapping("/addVehicle")
    public String addVehicleView(Model model) {

        model.addAttribute("brands", allBrandsRepository.findAll());
        model.addAttribute("enterprises", enterpriseRepository.findAll());

        return "homeAndVehicle/addVehicle.html";
    }

    // Посмотреть, как можно изменить добавление бренда
    // НЕ через merge
    @Transactional
    @PostMapping("/addVehicle")
    public String addVehicle(@ModelAttribute Vehicle vehicle,
                             @ModelAttribute Brand brand,
                             @RequestParam(name = "enterpriseId") int enterpriseId) {

        Enterprise e = entityManager.find(Enterprise.class, enterpriseId);
        vehicle.setEnterprise(e);
        Brand b = entityManager.merge(brand);
        vehicle.setBrand(b);
        entityManager.persist(vehicle);

        return REDIRECT_ADMIN_PANEL;
    }

    @PostMapping("/deleteVehicle")
    @Transactional
    public String deleteVehicle(@RequestParam int id) {

        Vehicle v = entityManager.find(Vehicle.class, id);
        entityManager.remove(v);

        return REDIRECT_ADMIN_PANEL;
    }

    @PostMapping("/changeVehicleView")
    public String changeVehicleView(@RequestParam int id,
                                    @ModelAttribute Vehicle vehicle,
                                    Model model) {

        model.addAttribute("brands", allBrandsRepository.findAll());
        model.addAttribute("v", vehicleRepository.findVehicleById(id));
        model.addAttribute("enterprises", enterpriseRepository.findAll());

        return "homeAndVehicle/changeVehicleView.html";
    }

//     Работает, но нужно поправить вью
//     там где-то ошибка, передается id бренда
//     одинаковый с id транспорта
    // П.С. Я пытался, id бренда не передается, почему-то
    @Transactional
    @PostMapping("/changeVehicle")
    public String changeVehicle(@ModelAttribute Vehicle vehicle,
                                @ModelAttribute Brand brand,
                                @RequestParam(name = "enterpriseId") int enterpriseId,
                                @RequestParam int idBrand) {
        Enterprise e = entityManager.find(Enterprise.class, enterpriseId);
        vehicle.setEnterprise(e);
        brand.setId(idBrand);
        vehicle.setBrand(brand);
        entityManager.merge(vehicle);

        return REDIRECT_ADMIN_PANEL;
    }

}
