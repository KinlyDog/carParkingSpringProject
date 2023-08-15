package com.kinlydog.carparking.dto;

import lombok.Data;

import java.util.List;

@Data
public class VehicleDTO {

    private int id;

    private int brandId;

    private String color;

    private int year;

    private int odometer;

    private int price;

    private int enterpriseId;

    private int activeDriverId;

    private List<Integer> drivers;
}
