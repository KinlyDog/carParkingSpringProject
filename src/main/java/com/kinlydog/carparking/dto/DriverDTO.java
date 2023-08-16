package com.kinlydog.carparking.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class DriverDTO {

    private int id;

    private String name;

    private int age;

    private int salary;

    private int enterpriseId;

    private int activeVehicleId;

    private Set<Integer> vehicles;
}
