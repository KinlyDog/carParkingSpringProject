package com.kinlydog.carparking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "salary")
    private int salary;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;

    @OneToOne(mappedBy = "activeDriver")
    private Vehicle activeVehicle;

    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
    private Set<VehicleDriverAssignment> vehicleAssignments;
}
