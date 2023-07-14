package com.msd.msd.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vendor")
@Data
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;

}
