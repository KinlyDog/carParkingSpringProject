package com.kinlydog.carparking.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "driver_vehicle")
public class DriverVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

}