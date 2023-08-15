package com.kinlydog.carparking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "safety_rating")
    private String safetyRating;

    @Column(name = "seating_capacity")
    private int seatingCapacity;

    @Column(name = "fuel_capacity")
    private int fuelCapacity;

    @Column(name = "average_lkm")
    private BigDecimal averageLKM;

    @OneToMany(mappedBy = "brand")
    private List<Vehicle> vehicles;
}

