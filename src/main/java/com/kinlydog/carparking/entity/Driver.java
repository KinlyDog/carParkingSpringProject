package com.kinlydog.carparking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "salary")
    private int salary;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;


    @OneToMany(mappedBy = "activeDriver")
    private List<Vehicle> vehicles;

    @ManyToOne
    @JoinColumn(name = "active_vehicle_id")
    private Vehicle activeVehicle;
}
