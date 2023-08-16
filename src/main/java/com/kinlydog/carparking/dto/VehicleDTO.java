package com.kinlydog.carparking.dto;

import com.kinlydog.carparking.entity.VehicleDriverAssignment;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

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

    private Set<Integer> drivers;
}
