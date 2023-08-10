package com.kinlydog.carparking.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "all_brands")
public class AllBrands {

    @Id
    int id;

    String name;
}
