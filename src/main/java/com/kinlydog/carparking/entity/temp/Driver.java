//package com.kinlydog.carparking.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Data
//@Entity
//@Table(name = "drivers")
//public class Driver {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    int id;
//
//    String name;
//
//    int age;
//
//    int salary;
//
//    // ok
//    @ManyToOne
//    @JoinColumn(name = "enterprise_id")
//    private Enterprise enterprise;
//
//    @OneToOne(mappedBy = "activeDriver")
//    private Vehicle activeVehicle;
//}
