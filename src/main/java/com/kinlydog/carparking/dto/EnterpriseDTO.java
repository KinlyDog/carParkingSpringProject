package com.kinlydog.carparking.dto;

import lombok.Data;

import java.util.List;

@Data
public class EnterpriseDTO {

    int id;

    String name;

    String city;

    private List<Integer> drivers;

    private List<Integer> vehicles;
}
