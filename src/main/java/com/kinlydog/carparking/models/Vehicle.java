package com.kinlydog.carparking.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int year;

    private int odometer;

    private String color;

    private BigDecimal price;

    // ok
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    // ok
    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    @OneToMany(mappedBy = "vehicle")
    private List<DriverVehicle> driverVehicles;

    @OneToOne(mappedBy = "activeVehicle")
    private Driver activeDriver;

}
