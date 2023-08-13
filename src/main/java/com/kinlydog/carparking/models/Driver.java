package com.kinlydog.carparking.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    int salary;

    // ok
    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    // ok
    @OneToMany(mappedBy = "driver")
    private List<DriverVehicle> driverVehicles;

    // ok
    @OneToOne
    @JoinColumn(name = "active_vehicle_id")
    private Vehicle activeVehicle;
}
