package com.kinlydog.carparking.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    private int id;

    private int year;

    private int odometer;

    private String color;

    private BigDecimal price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
