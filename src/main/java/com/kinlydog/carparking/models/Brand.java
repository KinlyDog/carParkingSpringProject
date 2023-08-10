package com.kinlydog.carparking.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "brands")
public class Brand {

    @Id
    private int id;

    private String name;

    private String safetyRating;

    private int seatingCapacity;

    private int fuelCapacity;

    @Column(name = "average_lkm")
    private BigDecimal averageLKM;

    //TODO перевести в enum
    private String type;
}

