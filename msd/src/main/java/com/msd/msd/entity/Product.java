package com.msd.msd.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;


    @ManyToMany(  fetch = FetchType.LAZY,
                  cascade = {CascadeType.PERSIST,
                             CascadeType.MERGE},
                  mappedBy = "products")
    @JsonIgnore
    List<Order> orders;
}
