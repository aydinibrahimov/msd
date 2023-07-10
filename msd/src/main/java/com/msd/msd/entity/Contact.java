package com.msd.msd.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String contact;
    private Long contactType;

}
