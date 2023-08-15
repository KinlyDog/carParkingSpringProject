package com.kinlydog.carparking.dto;

import lombok.Data;

import java.util.List;

@Data
public class DriverDTO {

    private int id;

    private String name;

    private int age;

    private int salary;

    private int enterpriseId;

    private int activeVehicleId;

    private List<Integer> vehicles;
}
