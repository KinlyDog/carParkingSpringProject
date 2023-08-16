package com.kinlydog.carparking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToOne
    @JoinColumn(name = "active_driver_id")
    private Driver activeDriver;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    private Set<VehicleDriverAssignment> driverAssignments;

}