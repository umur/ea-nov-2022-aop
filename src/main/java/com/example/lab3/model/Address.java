package com.example.lab3.model;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private int zip;
    private String city;

    @OneToOne(mappedBy = "address")
    private User1 user;
}
