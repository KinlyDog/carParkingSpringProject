package com.kinlydog.carparking.entity;

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
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "color")
    private String color;

    @Column(name = "year")
    private int year;

    @Column(name = "odometer")
    private int odometer;

    @Column(name = "price")
    private int price;

//    // ok
//    @ManyToOne
//    @JoinColumn(name = "enterprise_id")
//    private Enterprise enterprise;
//
//    @OneToMany
//    @JoinColumn(name = "driver_id")
//    private List<Driver> drivers;
//
//    @OneToOne
//    @JoinColumn(name = "active_driver_id")
//    private Driver activeDriver;
}