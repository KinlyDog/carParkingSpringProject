//package com.kinlydog.carparking.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.List;
//
//@Data
//@Entity
//@Table(name = "enterprises")
//public class Enterprise {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    int id;
//
//    String name;
//
//    String city;
//
//    // ok
//    @OneToMany(mappedBy = "enterprise")
//    private List<Vehicle> vehicles;
//
//    // ok
//    @OneToMany(mappedBy = "enterprise")
//    private List<Driver> drivers;
//}
