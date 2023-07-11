package com.msd.msd.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "vender")
public class Vender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;

}
