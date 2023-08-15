package com.kinlydog.carparking.dto;

import lombok.Data;

@Data
public class VehicleDTO {

    private int id;

    private int brand_id;

    private String color;

    private int year;

    private int odometer;

    private int price;
}
