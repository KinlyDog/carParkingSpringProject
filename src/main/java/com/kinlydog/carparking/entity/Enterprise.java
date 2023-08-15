package com.kinlydog.carparking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "enterprises")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @OneToMany(mappedBy = "enterprise")
    private List<Driver> drivers;

    @OneToMany(mappedBy = "enterprise")
    private List<Vehicle> vehicles;
}
