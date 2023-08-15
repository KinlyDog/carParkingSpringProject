package com.kinlydog.carparking.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BrandDTO {

    private int id;

    private String name;

    private String type;

    private String safetyRating;

    private int seatingCapacity;

    private int fuelCapacity;

    private BigDecimal averageLKM;

    private List<Integer> vehicles;
}
