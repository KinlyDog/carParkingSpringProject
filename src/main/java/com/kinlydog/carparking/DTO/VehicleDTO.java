package com.kinlydog.carparking.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VehicleDTO {

    private int id;

    private int year;

    private int odometer;

    private String color;

    private BigDecimal price;

    private int brandId;
}
