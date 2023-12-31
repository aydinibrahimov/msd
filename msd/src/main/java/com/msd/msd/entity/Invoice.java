package com.msd.msd.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Table(name = "invoice")
@Data
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long invoiceNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private Client client;


    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "invoice",
               fetch = FetchType.LAZY)
    List<Order> orders;
}
