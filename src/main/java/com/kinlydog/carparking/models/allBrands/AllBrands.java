package com.kinlydog.carparking.models.allBrands;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "all_brands")
public class AllBrands {

    @Id
    int id;

    String name;
}
