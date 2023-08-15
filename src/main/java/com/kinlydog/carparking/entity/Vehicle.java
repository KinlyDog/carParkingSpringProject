package com.kinlydog.carparking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
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

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    @OneToMany(mappedBy = "activeVehicle")
    private List<Driver> drivers;

    @ManyToOne
    @JoinColumn(name = "active_driver_id")
    private Driver activeDriver;
}